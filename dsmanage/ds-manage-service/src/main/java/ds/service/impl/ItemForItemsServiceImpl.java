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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemForItemsServiceImpl implements ItemForItemsService{
    @Autowired
    private ItemForItemsMapper itemForItemsMapper;

    @Override
    public DataGridResult getItemForItemsByItemsId(long id,long page,long rows) {
        ItemForItemsExample itemForItemsExample=new ItemForItemsExample();
        ItemForItemsExample.Criteria criteria=itemForItemsExample.createCriteria();
        criteria.andItemsIdEqualTo(id);
        criteria.andValuedEqualTo(true);
        PageHelper.startPage((int)page,(int)rows);
        List<ItemForItems> list=itemForItemsMapper.selectByExample(itemForItemsExample);
        PageInfo<ItemForItems> pageInfo=new PageInfo<>(list);
        long total=pageInfo.getTotal();
        DataGridResult dataGridResult=new DataGridResult(total,list);
        return dataGridResult;
    }

    @Override
    public Map upperOrLowerShelf(ItemForItems itemForItems,int flag){//flag=1 进行上架操作 flag=2 进行下架操作
        Map result=new HashMap();
        ItemForItemsExample itemForItemsExample=new ItemForItemsExample();
        ItemForItemsExample.Criteria criteria=itemForItemsExample.createCriteria();
        criteria.andItemIdEqualTo(itemForItems.getItemId());
        criteria.andValuedEqualTo(true);
        if(itemForItems.getItemId()==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","lack itemId (PK)");
            return result;
        }
        int res;
        if(flag==1){
            if(itemForItems.getStatus()==(byte)1)
            {
                result.put("statu","failed");
                result.put("code","2");
                result.put("message","已经是上架状态");
                return result;
            }
            ItemForItems upper=new ItemForItems();
            upper.setStatus((byte)1);//上架变量
            res=itemForItemsMapper.updateByExampleSelective(upper,itemForItemsExample);
        }
        else if(flag==2){
            if(itemForItems.getStatus()==(byte)1)
            {
                result.put("statu","failed");
                result.put("code","2");
                result.put("message","已经是下架状态");
                return result;
            }
            ItemForItems lower=new ItemForItems();
            lower.setStatus((byte)2);//下架变量
            res=itemForItemsMapper.updateByExampleSelective(lower,itemForItemsExample);
        }else{
            result.put("statu","failed");
            result.put("code","3");
            result.put("message","wrong flag");
            return result;
        }
        if (res==0){
            result.put("statu","failed");
            result.put("code","4");
            result.put("message","fail to oprate");
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","operate success");
        return result;
    }
}
