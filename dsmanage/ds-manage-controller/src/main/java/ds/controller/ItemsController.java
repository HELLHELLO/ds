package ds.controller;

import ds.common.pojo.DataGridResult;
import ds.pojo.Items;
import ds.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemService;

    @RequestMapping("/{itemsId}")
    @ResponseBody
    public Items getItemsById(@PathVariable Long itemsId){
        Items items=itemService.getItemsById(itemsId);
        return items;
    }

    @RequestMapping("list")
    @ResponseBody
    public DataGridResult getItemsList(@RequestParam(defaultValue = "1") Long page,@RequestParam(defaultValue = "30") Long rows){
        DataGridResult dataGridResult=itemService.getItemsList(page,rows);
        return dataGridResult;
    }
}
