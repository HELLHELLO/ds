package ds.service.impl;

import ds.mapper.ItemsParamMapper;
import ds.pojo.ItemsParam;
import ds.pojo.ItemsParamExample;
import ds.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private ItemsParamMapper itemsParamMapper;

    @Override
    public Map getItemParamServiceByCatId(Long catId){
        Map result=new HashMap();
        if (catId==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","missing id");
            return result;
        }

        ItemsParamExample itemsParamExample=new ItemsParamExample();
        ItemsParamExample.Criteria criteria=itemsParamExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andCidEqualTo(catId);
        List<ItemsParam> list=itemsParamMapper.selectByExampleWithBLOBs(itemsParamExample);
        if(list.size()==0||list==null){
            result.put("statu","success");
            result.put("code","0");
            result.put("message","success,empty list");
            result.put("list",null);
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","success");
        result.put("list",list);
        return result;
    }

    @Override
    public Map addItemParamServiceByCatId(Long catId, String paramData) {
        Map result=new HashMap();
        if(catId==null||paramData==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","missing param");
            return result;
        }

        ItemsParam itemsParam=new ItemsParam();
        itemsParam.setCid(catId);
        itemsParam.setParamData(paramData);
        itemsParam.setValued(true);

        int res=itemsParamMapper.insertSelective(itemsParam);
        if(res==0){
            result.put("statu","failed");
            result.put("code","2");
            result.put("message","insert failed");
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","add success");
        return result;
    }
}
