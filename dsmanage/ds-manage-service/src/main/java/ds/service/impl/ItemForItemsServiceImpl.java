package ds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ds.common.pojo.DataGridResult;
import ds.mapper.ItemForItemsMapper;
import ds.pojo.ItemForItems;
import ds.pojo.ItemForItemsExample;
import ds.service.ItemForItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemForItemsServiceImpl implements ItemForItemsService{
    @Autowired
    private ItemForItemsMapper itemForItemsMapper;

    @Override
    public DataGridResult getItemForItemsByItemsId(long id,long page,long rows) {
        ItemForItemsExample itemForItemsExample=new ItemForItemsExample();
        ItemForItemsExample.Criteria criteria=itemForItemsExample.createCriteria();
        criteria.andItemsIdEqualTo(id);
        PageHelper.startPage((int)page,(int)rows);
        List<ItemForItems> list=itemForItemsMapper.selectByExample(itemForItemsExample);
        PageInfo<ItemForItems> pageInfo=new PageInfo<>(list);
        long total=pageInfo.getTotal();
        DataGridResult dataGridResult=new DataGridResult(total,list);
        return dataGridResult;
    }
}
