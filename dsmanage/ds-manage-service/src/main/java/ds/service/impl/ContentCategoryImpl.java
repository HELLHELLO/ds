package ds.service.impl;

import ds.common.pojo.CatTree;
import ds.mapper.ContentCategoryMapper;
import ds.pojo.Content;
import ds.pojo.ContentCategory;
import ds.pojo.ContentCategoryExample;
import ds.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentCategoryImpl implements ContentCategoryService {
    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    private static final int ROOTID=0;  //默认一级分类父分类id为0

    @Override
    public Map getList() {
        Map result=new HashMap();
        List<CatTree> list=getCatTreeByRootId(ROOTID);
        result.put("statu","success");
        result.put("code","0");
        result.put("message","get list success");
        result.put("list",list);
        return result;
    }

    //根据根节点获取子节点的子树
    private List<CatTree> getCatTreeByRootId(long id){
        //设置查询条件
        ContentCategoryExample contentCategoryExample=new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria=contentCategoryExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andParentIdEqualTo(id);

        //获取所有子分类
        List<ContentCategory> list=contentCategoryMapper.selectByExample(contentCategoryExample);
        List<CatTree> result=new ArrayList<CatTree>();
        for (ContentCategory child:list){
            CatTree oneChild=new CatTree(child);
            result.add(oneChild);
        }

        //递归查找子分类的子分类
        for (CatTree node:result){
            ContentCategory root=(ContentCategory) node.getCat();
            //若不是父节点则跳过
            if (!root.getIsParent()){
                continue;
            }else{
                node.setChildren(getCatTreeByRootId(root.getId()));
            }
        }
        return result;
    }

    @Override
    public Map addCate(ContentCategory addCate) {
        Map result=new HashMap();
        addCate.setId(null);
        addCate.setIsParent(null);
        addCate.setCreated(null);
        addCate.setUpdated(null);
        addCate.setValued(null);

        //检查其父分类是否已被设置为是父分类,没有的话就更新父分类相应字段
        ContentCategory newParent=new ContentCategory();
        ContentCategory parent=contentCategoryMapper.selectByPrimaryKey(addCate.getParentId());
        if (!parent.getIsParent()){
            newParent.setIsParent(true);
            newParent.setId(parent.getId());
            contentCategoryMapper.updateByPrimaryKeySelective(newParent);
        }


        if (addCate.getName()==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","empty name");
            return result;
        }
        int num=contentCategoryMapper.insertSelective(addCate);
        if (num==0){
            result.put("statu","failed");
            result.put("code","2");
            result.put("message","fail to insert");
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","add success");
        return result;
    }


    public boolean delete(Long id) {
        //获取该分类的所有子分类
        ContentCategoryExample contentCategoryExample=new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria=contentCategoryExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andParentIdEqualTo(id);
        List<ContentCategory> list=contentCategoryMapper.selectByExample(contentCategoryExample);

        boolean success=true;
        //递归对所有子分类执行删除操作
        for (ContentCategory child:list){
            success=delete(child.getId());
            if (!success){
                return false;
            }
        }

        //删除该分类
        ContentCategory delCate=new ContentCategory();
        delCate.setId(id);
        delCate.setValued(false);
        int num=contentCategoryMapper.updateByPrimaryKeySelective(delCate);
        if (num==0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Map deleteCate(Long id) {
        Map result=new HashMap();
        boolean success;
        success=delete(id);
        if (success){
            result.put("statu","success");
            result.put("code","0");
            result.put("message","delete success");
            return result;
        }else{
            result.put("statu","failed");
            result.put("code","2");
            result.put("message","delete failed");
            return result;
        }
    }

    @Override
    public Map updateCate(String name,Long id) {
        Map result=new HashMap();
        //检测参数是否为空
        if (name==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","empty name");
            return result;
        }
        if(id==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","empty id");
            return result;
        }

        ContentCategory updateCate=new ContentCategory();
        updateCate.setId(id);
        updateCate.setName(name);
        int num=contentCategoryMapper.updateByPrimaryKeySelective(updateCate);
        if (num==0){
            result.put("statu","failed");
            result.put("code","2");
            result.put("message","update failed");
            return result;
        }else{
            result.put("statu","success");
            result.put("code","0");
            result.put("message","update success");
            return result;
        }
    }
}
