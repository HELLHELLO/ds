package ds.service;



import java.util.Map;

public interface OrderService {
    Map getOrderList();//只显示order表里面的内容
    Map getOrderById(Long orderId,Long orderShippingId);//针对一个订单，给出order和order_shipping的内容
}
