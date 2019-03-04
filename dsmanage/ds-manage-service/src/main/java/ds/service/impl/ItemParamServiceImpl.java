package ds.service.impl;

import ds.common.pojo.Result;
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
    public Result getItemParamServiceByCatId(Long catId){
        if (catId==null){
            return new Result(Result.Status.emptyParam,"empty cid");
        }

        ItemsParamExample itemsParamExample=new ItemsParamExample();
        ItemsParamExample.Criteria criteria=itemsParamExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andCidEqualTo(catId);
        List<ItemsParam> list=itemsParamMapper.selectByExampleWithBLOBs(itemsParamExample);
        if(list.size()==0||list==null){
            return new Result(Result.Status.success,"success but the list is empty",null);
        }
        return new Result(Result.Status.success,"success",list);
    }

    @Override
    public Result addItemParamServiceByCatId(Long catId, String paramData) {
        if(catId==null||paramData==null){
            return new Result(Result.Status.emptyParam,"empty param");
        }

        ItemsParam itemsParam=new ItemsParam();
        itemsParam.setCid(catId);
        itemsParam.setParamData(paramData);
        itemsParam.setValued(true);

        int res=itemsParamMapper.insertSelective(itemsParam);
        if(res==0){
            return new Result(Result.Status.somethingWrong,"failed to insert");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result delItemParam(Long id) {
        if (id==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }
        ItemsParam itemsParam=new ItemsParam();
        itemsParam.setValued(false);
        itemsParam.setId(id);
        Integer num=itemsParamMapper.updateByPrimaryKeySelective(itemsParam);
        if (num==0){
            return new Result(Result.Status.somethingWrong,"the record is not exist");
        }
        return new Result(Result.Status.success,"success");
    }
}
