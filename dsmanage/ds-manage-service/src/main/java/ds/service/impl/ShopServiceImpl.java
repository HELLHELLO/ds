package ds.service.impl;

import ds.mapper.UserShopMapper;
import ds.pojo.UserShop;
import ds.pojo.UserShopExample;
import ds.pojo.UserShopWithBLOBs;
import ds.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private UserShopMapper userShopMapper;

    @Override
    public Map getShopList() {
        List<UserShop> list=userShopMapper.selectByExample(new UserShopExample());
        Map result=new HashMap();
        result.put("statu","success");
        result.put("code","0");
        result.put("message","get list success");
        result.put("list",list);
        return result;
    }

    @Override
    public Map searchShop(UserShop userShop,Boolean all) {
        UserShopExample userShopExample=new UserShopExample();
        UserShopExample.Criteria criteria=userShopExample.createCriteria();
        criteria.andValuedEqualTo(true);

        //根据传入的参数设置查询条件
        if (userShop.getShopName()!=null){
            criteria.andShopNameLike(userShop.getShopName());
        }
        if (userShop.getAddress()!=null){
            criteria.andAddressLike(userShop.getAddress());
        }
        if (userShop.getUserId()!=null){
            criteria.andUserIdEqualTo(userShop.getUserId());
        }
        if (userShop.getLinkMan()!=null){
            criteria.andLinkManLike(userShop.getLinkMan());
        }
        if(userShop.getLinkPhone()!=null){
            criteria.andLinkPhoneEqualTo(userShop.getLinkPhone());
        }
        if (userShop.getBankName()!=null){
            criteria.andBankNameLike(userShop.getBankName());
        }
        if (userShop.getBankAccount()!=null){
            criteria.andBankAccountEqualTo(userShop.getBankAccount());
        }
        if (userShop.getShopId()!=null){
            criteria.andShopIdEqualTo(userShop.getShopId());
        }

        //根据all的值决定是否获取全部字段
        List<? extends UserShop> list;
        if(all){
            list=userShopMapper.selectByExampleWithBLOBs(userShopExample);
        }else {
            list = userShopMapper.selectByExample(userShopExample);
        }
        Map result=new HashMap();
        result.put("statu","success");
        result.put("code","0");
        result.put("message","get list success");
        result.put("list",list);

        return result;
    }

    @Override
    public Map updateShop(Long id, String name, String head) {
        Map result=new HashMap();
        if (id==null){
            result.put("statu","failed");
            result.put("code","6");
            result.put("message","missing ShopId");
            return result;
        }
        UserShopWithBLOBs userShop=new UserShopWithBLOBs();
        userShop.setShopId(id);
        userShop.setShopName(name);
        userShop.setShopHead(head);
        userShopMapper.updateByPrimaryKeySelective(userShop);
        result.put("statu","success");
        result.put("code","0");
        result.put("message","update success");
        return result;
    }


}
