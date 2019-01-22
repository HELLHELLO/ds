package ds.service;

import ds.pojo.Items;;
import java.util.Map;

public interface ItemOpService {
    Map addItem(Items items);
    //boolean addItem(Long itemsId, Long shopId, Long brandI, String name, Date created, Date updated, Long price, String unit, String shopName, Long cid, String brandName, String image, Boolean valued, String itemDesc);
    Map delItemById(Long itemsId);
    Map delItemByName(String name);
    //Map updateItem(Items items, Long itemsId);
    Map updateItem(Items items);
    Map updateItemsDesc(String desc,Long ItemsId);
}
