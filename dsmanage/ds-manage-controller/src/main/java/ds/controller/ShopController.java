package ds.controller;

import ds.common.pojo.Result;
import ds.pojo.UserShop;
import ds.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/list")
    @ResponseBody
    public Result getShopList(){
        return shopService.getShopList();
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public Result searchShop(UserShop userShop, @RequestParam(value = "all",defaultValue = "false") Boolean all){
        return shopService.searchShop(userShop,all);
    }
    @RequestMapping(value = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result updateShop(@RequestParam(value = "id",required = false) Long id,@RequestParam(value = "name",required = false) String name,@RequestParam(value = "head",required = false) String head){
        return shopService.updateShop(id,name,head);
    }
}
