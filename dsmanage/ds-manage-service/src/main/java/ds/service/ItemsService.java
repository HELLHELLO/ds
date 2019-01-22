package ds.service;

import ds.common.pojo.DataGridResult;
import ds.pojo.Items;

import java.util.Map;

/**
 * 获取商品的信息，根据id进行查询或获取全部商品的信息
 */
public interface ItemsService {
    Items getItemsById(Long itemsId);
    DataGridResult getItemsList(Long page,Long rows);
    Map getItemsDescByItemsId(Long itemsId);
}
