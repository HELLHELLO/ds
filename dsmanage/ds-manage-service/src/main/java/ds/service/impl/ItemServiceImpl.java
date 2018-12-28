package ds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ds.common.pojo.DataGridResult;
import ds.mapper.ItemsMapper;
import ds.pageHelperTools.GetSelectResult;
import ds.pojo.Items;
import ds.pojo.ItemsExample;
import ds.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ItemServiceImpl implements ItemsService {
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

    @Override
    public DataGridResult getItemsList(long page, long rows) {
        ItemsExample itemsExample=new ItemsExample();
        DataGridResult result=new GetSelectResult<ItemsMapper,ItemsExample,Items>((int)page,(int)rows,itemsMapper,itemsExample).getResult();
        return result;
        /*PageHelper.startPage((int)page,(int)rows);
        List<Items> list=itemsMapper.selectByExample(itemsExample);
        PageInfo<Items> pageInfo=new PageInfo<>(list);
        long total=pageInfo.getTotal();
        DataGridResult result=new DataGridResult(total,list);
        return result;*/
    }
}
