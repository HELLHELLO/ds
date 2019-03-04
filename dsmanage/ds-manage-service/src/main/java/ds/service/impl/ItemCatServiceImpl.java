package ds.service.impl;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr;
import ds.common.pojo.CatTree;
import ds.common.pojo.Result;
import ds.mapper.ItemCatMapper;
import ds.mapper.ItemPicMapper;
import ds.pojo.ItemCat;
import ds.pojo.ItemCatExample;
import ds.pojo.ItemPic;
import ds.pojo.ItemPicExample;
import ds.service.ItemCatService;
import ds.service.PictureService;
import ds.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Autowired
    private ItemPicMapper itemPicMapper;

    @Value("${REST_BASE_ADDR}")
    private String REST_BASE_ADDR;
    @Value("${REDIS_SERVICE_ADDR}")
    private String REDIS_SERVICE_ADDR;
    @Value("${REDIS_CAT_ADDR}")
    private String REDIS_CAT_ADDR;

    private static final int ROOTID=0;      //规定所有一级分类的父节点ID为0

    @Override
    public Result getCatTree() {
        List<CatTree> result=this.getCatTreeByRootId(ROOTID);   //查询由根节点开始的分类树
        return new Result(Result.Status.success,"success",result);
    }

    /*
    我觉得这个地方可能效率会很慢，以后如果有办法改进的话再来修改
     */
    private List<CatTree> getCatTreeByRootId(long id){    //根据根节点的catId查询该分类的子分类
        ItemCatExample itemCatExample=new ItemCatExample();
        ItemCatExample.Criteria criteria=itemCatExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        criteria.andValuedEqualTo(true);        //查询有效字段
        List<ItemCat> list=itemCatMapper.selectByExample(itemCatExample);   //查询该节点的所有子分类
        List<CatTree> result=new ArrayList<CatTree>();      //将子分类组装为list
        for(ItemCat node:list){
            CatTree oneCat=new CatTree(node);       //把每一条子分类变为CatTree类型，留出下一级的子节点
            result.add(oneCat);
        }
        for(CatTree node:result){                   //递归查询该节点下的所有子分类
            ItemCat root=(ItemCat) node.getCat();
            if (!root.getIsParent()){
                continue;   //如果不是父节点，则跳过
            }
            Long searchId=root.getCatId();      //获取该节点的catId，作为父节点进行查询
            node.setChildren(this.getCatTreeByRootId(searchId));    //将查询结果设置为该节点的子分类列表
        }

        return result;


    }

    @Override
    public Result creatNewCat(ItemCat itemCat) {
        if (itemCat.getName()==null){       //如果该分类没有命名，直接报错
            return new Result(Result.Status.emptyParam,"empty name");
        }
        if ((itemCat.getParentId()==null)){   //如果未设定该分类的父分类，默认该分类为一级分类
            itemCat.setParentId((long)ROOTID);
            //itemCat.setIsParent(true);
        }
        itemCat.setCreated(null);
        itemCat.setUpdated(null);
        itemCat.setValued(null);
        itemCat.setStatus(null);
        itemCat.setCatId(null);
        itemCat.setIsParent(false);         //新创建的分类默认为不是父分类



        if(!this.checkPic(itemCat)){
            return new Result(Result.Status.somethingWrong,"picture does not exist");

        }

        if (itemCat.getParentId()!=ROOTID){              //如果设定了父分类，检查该父分类是否存在
            ItemCatExample checkExample=new ItemCatExample();
            ItemCatExample.Criteria criteria=checkExample.createCriteria();
            criteria.andCatIdEqualTo(itemCat.getParentId());    //设置查询条件
            long checkResult=itemCatMapper.countByExample(checkExample);    //获取查询结果条数
            if(checkResult==0){                         //若父分类不存在，报错
                return new Result(Result.Status.somethingWrong,"parentId does not exist");
            }else{
                ItemCat parentCat=new ItemCat();       //设置父分类的isParent属性
                parentCat.setIsParent(true);
                itemCatMapper.updateByExampleSelective(parentCat,checkExample);
            }
        }
        int insertResult=itemCatMapper.insertSelective(itemCat);    //写入数据库
        try {
            HttpClientUtil.doGet(REST_BASE_ADDR + REDIS_SERVICE_ADDR + REDIS_CAT_ADDR);
        }catch(Exception e){
            e.printStackTrace();
        }
        if (insertResult==0){
            return new Result(Result.Status.somethingWrong,"fail to insert");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result alterACatById(ItemCat itemCat) {
        itemCat.setCreated(null);
        itemCat.setUpdated(null);
        itemCat.setValued(null);
        itemCat.setStatus(null);
        itemCat.setIsParent(null);         //清空不允许修改的参数
        itemCat.setParentId(null);

        if (itemCat.getCatId()==null){
            return new Result(Result.Status.emptyParam,"empty catId");
        }
        boolean checkPicResult=checkPic(itemCat);
        if(!checkPicResult){                         //若图片不存在，报错
            return new Result(Result.Status.somethingWrong,"picture does not exist");
        }

        ItemCatExample itemCatExample=new ItemCatExample();
        itemCatExample.createCriteria().andCatIdEqualTo(itemCat.getCatId());
        int updateNum=itemCatMapper.updateByExampleSelective(itemCat,itemCatExample);
        try {
            HttpClientUtil.doGet(REST_BASE_ADDR + REDIS_SERVICE_ADDR + REDIS_CAT_ADDR);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(updateNum>0){
            return new Result(Result.Status.success,"success");
        }else{
            return new Result(Result.Status.somethingWrong,"fail to update");
        }

    }

    private boolean checkPic(ItemCat itemCat){
        if(itemCat.getPicId()!=null){       //如果设定了图片，检查图片是否存在
            ItemPicExample checkPicExample=new ItemPicExample();
            ItemPicExample.Criteria picCriteria=checkPicExample.createCriteria();
            picCriteria.andPicIdEqualTo(itemCat.getPicId());
            long checkPicResult=itemPicMapper.countByExample(checkPicExample);
            if(checkPicResult==0){                         //若图片不存在，报错
                return false;
            }else {
                return true;
            }
        }else {
            return true;
        }
    }

    @Override
    public Result deleteACatById(Long catId) {
        if (catId==null){
            return new Result(Result.Status.emptyParam,"empty catId");
        }
        ItemCat itemCat=new ItemCat();
        itemCat.setCatId(catId);

        ItemCatExample itemCatExample=new ItemCatExample();     //检查该分类是否存在
        itemCatExample.createCriteria().andCatIdEqualTo(catId).andValuedEqualTo(true);//设置查询条件
        long exist=itemCatMapper.countByExample(itemCatExample);
        if (exist==0){                                          //若该分类不存在，报错
            return new Result(Result.Status.somethingWrong,"target does not exist");
        }
        this.deleteCats(catId);
        try {
            HttpClientUtil.doGet(REST_BASE_ADDR + REDIS_SERVICE_ADDR + REDIS_CAT_ADDR);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Result(Result.Status.success,"success");
    }

    public void deleteCats(Long catId){ //递归删除所有子分类
        ItemCatExample itemCatExample=new ItemCatExample();
        itemCatExample.createCriteria().andParentIdEqualTo(catId).andValuedEqualTo(true);//设置查询条件

        ItemCat itemCat=itemCatMapper.selectByPrimaryKey(catId);
        itemCat.setValued(false);
        if (itemCat.getIsParent()){     //若是父分类，先删除其下的子分类
            List<ItemCat> children=itemCatMapper.selectByExample(itemCatExample);
            for(ItemCat child:children){
                deleteCats(child.getCatId());     //递归删除
            }
        }
        //itemCatMapper.deleteByPrimaryKey(catId);    //删除该分类
        itemCatMapper.updateByPrimaryKey(itemCat);    //删除该分类，为了效率，删除操作为将有效标志位设为无效
    }

}
