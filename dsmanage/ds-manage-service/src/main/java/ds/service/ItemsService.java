package ds.service;

import ds.common.pojo.DataGridResult;
import ds.pojo.Items;

public interface ItemsService {
    Items getItemsById(long itemsId);
    DataGridResult getItemsList(long page,long rows);
}
