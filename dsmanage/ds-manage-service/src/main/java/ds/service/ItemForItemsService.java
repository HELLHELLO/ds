package ds.service;

import ds.common.pojo.DataGridResult;
import ds.pojo.ItemForItems;

public interface ItemForItemsService {
    public DataGridResult getItemForItemsByItemsId(long id,long page,long rows);
}
