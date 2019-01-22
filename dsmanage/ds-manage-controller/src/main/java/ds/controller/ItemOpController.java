package ds.controller;

import ds.pojo.Items;
import ds.service.ItemOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/itemsop")
public class ItemOpController {
    @Autowired
    private ItemOpService itemOpService;

    @RequestMapping("/addItem")
    @ResponseBody
    public Map addItem(){//测试所用
        Items items=new Items();
        Map map=itemOpService.addItem(items);
        return map;
    }
    public Map addItem(@RequestParam Items items){
        Map map=itemOpService.addItem(items);
        return map;
    }

    @RequestMapping("/delItemById")
    @ResponseBody
    public Map delItemById(@RequestParam Long itemsId){
        Map map=itemOpService.delItemById(itemsId);
        return map;

    }

    @RequestMapping("/delItemByName")
    @ResponseBody
    public Map delItemByName(@RequestParam String name){
        Map map=itemOpService.delItemByName(name);
        return map;

    }

    @RequestMapping("/updateItem")
    @ResponseBody
    /*public Map updateItem(@RequestParam Items items,@RequestParam Long itemsId){
        Map map=itemOpService.updateItem(items,itemsId);
        return map;
    }*/
    public Map updateItem(@RequestParam Items items){
        Map map=itemOpService.updateItem(items);
        return map;
    }

    @RequestMapping(value = "/desc/update",method = RequestMethod.POST)
    @ResponseBody
    public Map updateItemsDesc(@RequestParam(value = "id",required = false) Long id,@RequestParam(value = "desc",required = false) String desc){
        return itemOpService.updateItemsDesc(desc,id);
    }
}