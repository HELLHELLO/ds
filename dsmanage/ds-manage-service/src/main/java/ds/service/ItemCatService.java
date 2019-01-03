package ds.service;

import ds.common.pojo.CatTree;
import ds.pojo.ItemCat;

import java.util.List;
import java.util.Map;

/**
 * 获取商品分类树，也就是全部的商品分类，包括分类之间的父子关系
 * 以及其他的关于商品分类的操作
 */
public interface ItemCatService {
    //获取商品分类树
    public List<CatTree> getCatTree();

    //创建一个新的分类
    public Map creatNewCat(ItemCat itemCat);

    //修改一个分类的信息
    public Map alterACatById(ItemCat itemCat);

    //删除一个分类及其下的所有子分类
    public Map deleteACatById(Long catId);
}
