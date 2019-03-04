package ds.controller;

import ds.common.pojo.Result;
import ds.pojo.Content;
import ds.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/list/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getContentList(@PathVariable Long id){
        return contentService.getContentList(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addContent(Content content){
        return contentService.addContent(content);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result updateContent(Content content){
        return contentService.updateContent(content);
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result delContentList(@PathVariable Long id){
        return contentService.delContent(id);
    }
}
