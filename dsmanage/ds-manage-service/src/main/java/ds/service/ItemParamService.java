package ds.service;

import ds.common.pojo.Result;

import java.util.Map;

public interface ItemParamService {
    public Result getItemParamServiceByCatId(Long catId);//获取商品参数模板
    public Result addItemParamServiceByCatId(Long catId,String paramData);//添加商品参数模板
    public Result delItemParam(Long id);//根据模板id进行删除
}
