package ds.rest.controller;

import ds.rest.pojo.Result;
import ds.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content")
public class ContentServiceController {
    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/list/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getContentList(@PathVariable(value = "id") Long id){
        Result result=contentService.getContentList(id);
        return result;
    }
}
