package ds.controller;

import ds.common.pojo.DataGridResult;
import ds.service.ItemForItemsService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/stuItem")
public class ItemForItemsController {

    @Autowired
    private ItemForItemsService itemForItemsService;

    @RequestMapping("/{id}")
    @ResponseBody
    public DataGridResult getItemForItemsByItemsId(@PathVariable long id, @RequestParam(defaultValue = "1") long page,@RequestParam(defaultValue = "30") long rows){
        DataGridResult result=itemForItemsService.getItemForItemsByItemsId(id,page,rows);
        return result;
    }
}
