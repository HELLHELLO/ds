package ds.controller;

import ds.common.pojo.DataGridResult;
import ds.common.pojo.Result;
import ds.pojo.Items;
import ds.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemService;

    @RequestMapping("/{itemsId}")
    @ResponseBody
    public Result getItemsById(@PathVariable Long itemsId){
        return itemService.getItemsById(itemsId);
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGridResult getItemsList(@RequestParam(defaultValue = "1") Long page,@RequestParam(defaultValue = "30") Long rows){
        DataGridResult dataGridResult=itemService.getItemsList(page,rows);
        return dataGridResult;
    }

    @RequestMapping(value = "/desc",method = RequestMethod.GET)
    @ResponseBody
    public Result getItemsDescByItemsId(@RequestParam(value = "id",required = false) Long id){
        return itemService.getItemsDescByItemsId(id);
    }
}
