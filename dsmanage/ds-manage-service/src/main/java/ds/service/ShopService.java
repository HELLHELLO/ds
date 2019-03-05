package ds.service;


import ds.common.pojo.Result;
import ds.pojo.User;
import ds.pojo.UserShop;

import java.util.Map;

//进行商铺管理的接口
public interface ShopService {
    public Result getShopList();   //获取商家列表
    public Result searchShop(UserShop userShop,Boolean all);   //按条件查询商家
    public Result updateShop(Long id,String name,String head); //根据id修改商家名与头像
   // public Map createAShop();//新增商家
}
