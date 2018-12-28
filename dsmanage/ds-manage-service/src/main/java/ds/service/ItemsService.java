package ds.service;

import ds.common.pojo.DataGridResult;
import ds.pojo.Items;

/**
 * 获取商品的信息，根据id进行查询或获取全部商品的信息
 */
public interface ItemsService {
    Items getItemsById(long itemsId);
    DataGridResult getItemsList(long page,long rows);
}
