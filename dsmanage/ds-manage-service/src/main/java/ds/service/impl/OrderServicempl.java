package ds.service.impl;

import ds.common.pojo.DataGridResult;
import ds.mapper.OrderMapper;
import ds.mapper.OrderShippingMapper;
import ds.pageHelperTools.GetSelectResult;
import ds.pojo.Order;
import ds.pojo.OrderExample;
import ds.pojo.OrderShipping;
import ds.pojo.OrderShippingExample;
import ds.service.OrderService;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServicempl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    private OrderShippingMapper orderShippingMapper;
    @Override
    public Map getOrderList(){
        Map result=new HashMap();
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria=orderExample.createCriteria();
        criteria.andValuedEqualTo(true);
        List<Order> list=orderMapper.selectByExample(orderExample);
        if(list==null){
            result.put("statu","fail");
            result.put("code","1");
            result.put("message","create list failed");
            return result;
        }else{
            if(list.size()==0){
                result.put("statu","fail");
                result.put("code","2");
                result.put("message","no order exists");
                return result;
            }else{
                result.put("statu","success");
                result.put("code","0");
                result.put("message","find orders");
                result.put("list",list);
                return result;
            }
        }
    }
    @Override
    public Map getOrderById(Long orderId,Long orderShippingId){
        Map result=new HashMap();
        Order order=orderMapper.selectByPrimaryKey(orderId);
        OrderShipping orderShipping=orderShippingMapper.selectByPrimaryKey(orderShippingId);
        if(order!=null&&order.getValued()==true){
            if(orderShipping!=null&&orderShipping.getValued()==true){
                result.put("statu","success");
                result.put("code","0");
                result.put("message","find order and orderShipping");
                result.put("order",order);
                result.put("orderShipping",orderShipping);
                return result;
            }else{
                result.put("statu","success");
                result.put("code","1");
                result.put("message","find order,but not find orderShipping");
                result.put("order",order);
                return result;
            }
        }else{
            result.put("statu","fail");
            result.put("code","2");
            result.put("message","no match order");
            return result;
        }
    }
    @Override
    Map getOrderByShipCode(String shippingCode){
        Map result=new HashMap();

        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria criteria=orderExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andShippingCodeEqualTo(shippingCode);
        List<Order> list=orderMapper.selectByExample(orderExample);

        OrderShippingExample orderShippingExample=new OrderShippingExample();
        OrderShippingExample.Criteria criteria1=orderShippingExample.createCriteria();
        criteria1.andValuedEqualTo(true);
        criteria1.andShippingCodeEqualTo(shippingCode);
        List<OrderShipping> list1=orderShippingMapper.selectByExample(orderShippingExample);

        if()
    }
}
