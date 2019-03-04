package ds.service;

import ds.common.pojo.Result;
import ds.pojo.ContentCategory;

import java.util.Map;

public interface ContentCategoryService {
    public Result getList();//获得分类列表
    public Result addCate(ContentCategory addCate);//添加分类
    public Result deleteCate(Long id);//根据id删除分类及其下所有子分类
    public Result updateCate(String name,Long id);//重命名一个分类
}
