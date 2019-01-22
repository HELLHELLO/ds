package ds.controller;

import ds.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping(value = "/itemcid/{cid}", method = RequestMethod.GET)
    @ResponseBody
    public Map getItemParamByCid(@PathVariable("cid") Long cid){
        return itemParamService.getItemParamServiceByCatId(cid);
    }

    @RequestMapping(value = "/add/{cid}",method = RequestMethod.POST)
    @ResponseBody
    public Map addItemParamByCid(@PathVariable("cid") Long cid, @RequestParam(value = "paramdata",required = false) String paramData){
        return itemParamService.addItemParamServiceByCatId(cid,paramData);
    }
}
