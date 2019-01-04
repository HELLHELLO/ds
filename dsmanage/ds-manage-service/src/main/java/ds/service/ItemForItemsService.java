package ds.service;

import ds.common.pojo.DataGridResult;
import ds.pojo.ItemForItems;

import java.util.Map;

/**
 * 根据items的id获取该商品的全部型号的具体商品的信息列表
 */
public interface ItemForItemsService {
    public DataGridResult getItemForItemsByItemsId(long id,long page,long rows);
    Map upperOrLowerShelf (ItemForItems itemForItems,int flag);//flag=1 进行上架操作 flag=2 进行下架操作
}
