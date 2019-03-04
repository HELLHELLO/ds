package ds.controller;

import ds.common.pojo.Result;
import ds.pojo.Expert;
import ds.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.Map;

@Controller
@RequestMapping("/expert")
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Result getExpertList(){
        return expertService.getExpertsList();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result updateExpertById(Expert expert){
        return expertService.updateExpertById(expert);
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public Result searchExpert(Expert expert,@RequestParam(value = "priceUpper",required = false) Boolean priceUpper){
        return expertService.searchExpert(expert,priceUpper);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteExpertById(@RequestParam(value = "id") Long id){
        return expertService.deleteExpertById(id);
    }
}
