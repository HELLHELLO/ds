package ds.rest.service.impl;

import ds.common.pojo.CatTree;
import ds.mapper.ItemCatMapper;
import ds.pojo.ItemCat;
import ds.pojo.ItemCatExample;

import ds.common.pojo.Result;
import ds.rest.service.ItemCatRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ds.common.pojo.Result;


@Service
public class ItemCatRestServiceImpl implements ItemCatRestService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    private static final int ROOTID=0;

    @Override
    public Result getItemCatList() {
        List<CatTree> tree=getCatTreeByRootId(ROOTID);
        Result result=new Result(Result.Status.success,"get list success",tree);
        return result;
    }

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
}
