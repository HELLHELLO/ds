package ds.service;

import ds.pojo.ContentCategory;

import java.util.Map;

public interface ContentCategoryService {
    public Map getList();//获得分类列表
    public Map addCate(ContentCategory addCate);//添加分类
    public Map deleteCate(Long id);//根据id删除分类及其下所有子分类
    public Map updateCate(String name,Long id);//重命名一个分类
}
