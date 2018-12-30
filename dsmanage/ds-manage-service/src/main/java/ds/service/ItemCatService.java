package ds.service;

import ds.common.pojo.CatTree;

import java.util.List;

/**
 * 获取商品分类树，也就是全部的商品分类，包括分类之间的父子关系
 */
public interface ItemCatService {
    public List<CatTree> getCatTree();
}
