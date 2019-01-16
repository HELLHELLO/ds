package ds.controller;

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
    public Map getContentList(@PathVariable Long id){
        Map result=contentService.getContentList(id);
        return result;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map addContent(Content content){
        Map result=contentService.addContent(content);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Map updateContent(Content content){
        Map result=contentService.updateContent(content);
        return result;
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map delContentList(@PathVariable Long id){
        Map result=contentService.delContent(id);
        return result;
    }
}
