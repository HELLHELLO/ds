package ds.controller;

import ds.common.pojo.Result;
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
    public Result getList(){
        return contentCategoryService.getList();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addCate(ContentCategory addCate){
        return contentCategoryService.addCate(addCate);
    }

    @RequestMapping(value = "/delete",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result deleteCate(@RequestParam(value = "id",required = false) Long id){
        return contentCategoryService.deleteCate(id);
    }

    @RequestMapping(value = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result updateCate(@RequestParam(value = "id",required = false) Long id,@RequestParam(value="name",required = false) String name){
        return contentCategoryService.updateCate(name,id);
    }
}
