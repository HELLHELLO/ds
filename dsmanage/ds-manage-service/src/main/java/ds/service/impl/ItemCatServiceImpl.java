package ds.service.impl;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr;
import ds.common.pojo.CatTree;
import ds.mapper.ItemCatMapper;
import ds.pojo.ItemCat;
import ds.pojo.ItemCatExample;
import ds.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    private static final int ROOTID=0;      //规定所有一级分类的父节点ID为0

    @Override
    public List<CatTree> getCatTree() {
        List<CatTree> result=this.getCatTreeByRootId(ROOTID);   //查询由根节点开始的分类树
        return result;
    }

/*
我觉得这个地方可能效率会很慢，以后如果有办法改进的话再来修改
 */

    /**
     * desc无法显示出来，好像和mysql的text类型有关系
     * @param id
     * @return result
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
}
