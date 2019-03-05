package ds.service;

import ds.common.pojo.DataGridResult;
import ds.common.pojo.Result;
import ds.pojo.Items;

import java.util.Map;

/**
 * 获取商品的信息，根据id进行查询或获取全部商品的信息
 */
public interface ItemsService {
    public Result getItemsById(Long itemsId);
    public DataGridResult getItemsList(Long page,Long rows);
    public Result getItemsDescByItemsId(Long itemsId);
}
