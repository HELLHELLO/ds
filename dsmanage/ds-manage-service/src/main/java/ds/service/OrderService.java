package ds.service;



import java.util.Map;

public interface OrderService {
    Map getOrderList();//只显示order表里面的内容，显示全部的订单列表
    /*实现功能 1点击查看详情  2根据订单号精准匹配

    Order——orderId  shippingId shopId userId
    OrderShipping——shippingId
    OrderItem——id  itemId  orderId

    获取一个订单，给出Order和OrderShipping和OrderItem的内容即*/
    Map getOrderById(Long orderId,Long orderShippingId);
   // Map getOrderByShop//通过店铺名搜索某店铺的全部订单
            //根据订单状态进行订单筛选

    //订单号 商家 商品

}
