package ds.controller;

import ds.pojo.ContentCategory;
import ds.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;
import java.util.Map;

@Controller
@RequestMapping("/con_cate")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Map getList(){
        Map result=contentCategoryService.getList();
        return result;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map addCate(ContentCategory addCate){
        Map result=contentCategoryService.addCate(addCate);
        return result;
    }

    @RequestMapping(value = "/delete",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map deleteCate(@RequestParam(value = "id",required = false) Long id){
        Map result=contentCategoryService.deleteCate(id);
        return result;
    }

    @RequestMapping(value = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map updateCate(@RequestParam(value = "id",required = false) Long id,@RequestParam(value="name",required = false) String name){
        Map result=contentCategoryService.updateCate(name,id);
        return result;
    }
}
