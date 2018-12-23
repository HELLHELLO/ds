package ds.service.impl;

import ds.mapper.ItemsMapper;
import ds.pojo.Items;
import ds.pojo.ItemsExample;
import ds.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public Items getItemsById(long itemsId){
        //itemsMapper.selectByPrimaryKey(itemsId);
        ItemsExample itemsExample=new ItemsExample();
        ItemsExample.Criteria criteria=itemsExample.createCriteria();
        criteria.andBrandIdEqualTo(itemsId);
        List<Items> result=itemsMapper.selectByExample(itemsExample);
        if(result!=null&&result.size()>0){
            Items items=result.get(0);
            return items;
        }
        return null;
    }
}
