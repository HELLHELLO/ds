package ds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ds.common.pojo.DataGridResult;
import ds.common.pojo.Result;
import ds.mapper.ItemsDescMapper;
import ds.mapper.ItemsMapper;
import ds.pageHelperTools.GetSelectResult;
import ds.pojo.Items;
import ds.pojo.ItemsDesc;
import ds.pojo.ItemsDescExample;
import ds.pojo.ItemsExample;
import ds.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ItemServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsDescMapper itemsDescMapper;
    @Override
    public Result getItemsById(Long itemsId){
        //itemsMapper.selectByPrimaryKey(itemsId);
        ItemsExample itemsExample=new ItemsExample();
        ItemsExample.Criteria criteria=itemsExample.createCriteria();
        criteria.andBrandIdEqualTo(itemsId);
        criteria.andValuedEqualTo(true);
        List<Items> result=itemsMapper.selectByExample(itemsExample);
        if(result!=null&&result.size()>0){
            return new Result(Result.Status.success,"success",result);
        }
        return new Result(Result.Status.somethingWrong,"the items do not exist");
    }

    @Override
    public DataGridResult getItemsList(Long page, Long rows) {
        ItemsExample itemsExample=new ItemsExample();
        itemsExample.createCriteria().andValuedEqualTo(true);
        long pag=page;
        long row=rows;
        DataGridResult result=new GetSelectResult<ItemsMapper,ItemsExample,Items>((int) pag,(int) row,itemsMapper,itemsExample).getResult();
        return result;
        /*PageHelper.startPage((int)page,(int)rows);
        List<Items> list=itemsMapper.selectByExample(itemsExample);
        PageInfo<Items> pageInfo=new PageInfo<>(list);
        long total=pageInfo.getTotal();
        DataGridResult result=new DataGridResult(total,list);
        return result;*/
    }

    @Override
    public Result getItemsDescByItemsId(Long itemsId) {
        if (itemsId==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }

        ItemsDescExample itemsDescExample=new ItemsDescExample();
        ItemsDescExample.Criteria criteria=itemsDescExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andItemIdEqualTo(itemsId);
        ItemsDesc itemsDesc=itemsDescMapper.selectByExampleWithBLOBs(itemsDescExample).get(0);
        List<String> desc=new ArrayList<String>();
        desc.add(itemsDesc.getItemDesc());
        return new Result(Result.Status.success,"success",desc);
    }
}
