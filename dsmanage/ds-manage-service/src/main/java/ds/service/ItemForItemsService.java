package ds.service;

import ds.common.pojo.DataGridResult;
import ds.pojo.ItemForItems;

/**
 * 根据items的id获取该商品的全部型号的具体商品的信息列表
 */
public interface ItemForItemsService {
    public DataGridResult getItemForItemsByItemsId(long id,long page,long rows);
}
