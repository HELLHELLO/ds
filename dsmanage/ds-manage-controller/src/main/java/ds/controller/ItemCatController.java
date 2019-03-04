package ds.controller;

import ds.common.pojo.CatTree;
import ds.common.pojo.Result;
import ds.pojo.ItemCat;
import ds.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Cats",method = {RequestMethod.GET,RequestMethod.POST})
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Result getCatList(){
        return itemCatService.getCatTree();
    }


    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public Result creatNewCat(ItemCat itemCat){
        return itemCatService.creatNewCat(itemCat);
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result updateACatById(ItemCat itemCat){
        return itemCatService.alterACatById(itemCat);
    }

    @RequestMapping(value = "/delete",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Result deleteACatById(@RequestParam(value = "catId",required = false) Long catId){
        return itemCatService.deleteACatById(catId);
    }

}
