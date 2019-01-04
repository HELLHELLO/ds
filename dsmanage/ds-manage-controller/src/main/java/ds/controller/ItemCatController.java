package ds.controller;

import ds.common.pojo.CatTree;
import ds.pojo.ItemCat;
import ds.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public List<CatTree> getCatList(){
        List<CatTree> result=itemCatService.getCatTree();
        return result;
    }


    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public Map creatNewCat(ItemCat itemCat){
        Map result=itemCatService.creatNewCat(itemCat);
        return result;
    }
}
