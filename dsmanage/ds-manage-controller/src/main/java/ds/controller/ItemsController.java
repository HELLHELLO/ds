package ds.controller;

import ds.pojo.Items;
import ds.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemsController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/items/{itemsId}")
    @ResponseBody
    public Items getItemsById(@PathVariable Long itemsId){
        Items items=itemService.getItemsById(itemsId);
        return items;
    }
}
