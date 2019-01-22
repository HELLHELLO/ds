package ds.service.impl;

import ds.mapper.ItemsDescMapper;
import ds.mapper.ItemsMapper;
import ds.pojo.Items;
import ds.pojo.ItemsDesc;
import ds.pojo.ItemsDescExample;
import ds.pojo.ItemsExample;
import ds.service.ItemOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemOpServicempl implements ItemOpService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsDescMapper itemsDescMapper;
    @Override
    public Map addItem(Items items){
        Map result=new HashMap();
        boolean[] arr=new boolean[9];
        arr[1]=(items.getShopId()==null);
        arr[2]=(items.getBrandId()==null);
        arr[3]=(items.getName()==null);
        arr[4]=(items.getPrice()==null);
        arr[5]=(items.getUnit()==null);
        arr[6]=(items.getShopName()==null);
        arr[7]=(items.getCid()==null);
        arr[8]=(items.getBrandName()==null);
        for(int i=1;i<=8;i++){
            if(arr[i]==true){
                result.put("statu","failed");
                result.put("code",i);
                switch (i){
                    case 1:result.put("message","empty shopId"); break;
                    case 2:result.put("message","empty brandId"); break;
                    case 3:result.put("message","empty name"); break;
                    case 4:result.put("message","empty price"); break;
                    case 5:result.put("message","empty unit"); break;
                    case 6:result.put("message","empty shopName"); break;
                    case 7:result.put("message","empty cid"); break;
                    case 8:result.put("message","empty brandName"); break;
                }
                return result;
            }
        }
        int res=itemsMapper.insertSelective(items);

        //生成一条空的商品描述用于以后进行商品描述的添加
        ItemsDesc itemsDesc=new ItemsDesc();
        itemsDesc.setItemId(items.getItemsId());
        itemsDesc.setValued(true);
        int res2=itemsDescMapper.insertSelective(itemsDesc);


        if (res==0||res2==0){
            result.put("statu","failed");
            result.put("code","9");
            result.put("message","fail to insert");
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","add success");
        return result;
    }
    @Override
    public Map delItemById(Long itemsId){
        Map result=new HashMap();
        ItemsExample itemsExample=new ItemsExample();
        ItemsExample.Criteria criteria=itemsExample.createCriteria();
        criteria.andItemsIdEqualTo(itemsId);
        Items items=new Items();
        items.setValued(false);
        int res=itemsMapper.updateByExampleSelective(items,itemsExample);

        //同步删除商品描述
        ItemsDescExample itemsDescExample=new ItemsDescExample();
        ItemsDescExample.Criteria descCriteria=itemsDescExample.createCriteria();
        descCriteria.andItemIdEqualTo(itemsId);
        ItemsDesc itemsDesc=new ItemsDesc();
        itemsDesc.setValued(false);
        int res2=itemsDescMapper.updateByExampleSelective(itemsDesc,itemsDescExample);


        if (res==0||res2==0){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","fail to delete by id");
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","delete by id success");
        return result;
    }

    //这个方法没有必要吧？
    @Override
    public Map delItemByName(String name){
        Map result=new HashMap();
        ItemsExample itemsExample=new ItemsExample();
        ItemsExample.Criteria criteria=itemsExample.createCriteria();
        criteria.andNameEqualTo(name);
        Items items=new Items();
        items.setValued(false);
        int res=itemsMapper.updateByExampleSelective(items,itemsExample);
        if (res==0){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","fail to delete by name");
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","delete by id success");
        return result;
    }
    @Override
    //public Map updateItem(Items items,Long itemsId){
    public Map updateItem(Items items){
        Map result=new HashMap();
        ItemsExample itemsExample=new ItemsExample();
        ItemsExample.Criteria criteria=itemsExample.createCriteria();
        //criteria.andItemsIdEqualTo(itemsId);
        if(items.getItemsId()==null){
            result.put("statu","failed");
            result.put("code","2");
            result.put("message","lack itemsId (PK)");
            return result;
        }
        criteria.andItemsIdEqualTo(items.getItemsId());
        criteria.andValuedEqualTo(true);
        int res=itemsMapper.updateByExampleSelective(items,itemsExample);
        if (res==0){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","fail to update");
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","update success");
        return result;
    }

    @Override
    public Map updateItemsDesc(String desc, Long itemsId) {
        Map result=new HashMap();

        if (itemsId==null||desc==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","missing param");
            return result;
        }

        ItemsDescExample itemsDescExample=new ItemsDescExample();
        ItemsDescExample.Criteria criteria=itemsDescExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andItemIdEqualTo(itemsId);
        ItemsDesc itemsDesc=new ItemsDesc();
        itemsDesc.setItemId(itemsId);
        itemsDesc.setItemDesc(desc);
        int res=itemsDescMapper.updateByExampleSelective(itemsDesc,itemsDescExample);

        if (res==0){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","fail to update");
            return result;
        }
        result.put("statu","success");
        result.put("code","0");
        result.put("message","update success");
        return result;
    }
}
