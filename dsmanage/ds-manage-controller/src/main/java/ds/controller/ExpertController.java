package ds.controller;

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
    public Map getExpertList(){
        Map result=expertService.getExpertsList();
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Map updateExpertById(Expert expert){
        Map result=expertService.updateExpertById(expert);
        return result;
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public Map searchExpert(Expert expert,@RequestParam(value = "priceUpper",required = false) Boolean priceUpper){
        Map result=expertService.searchExpert(expert,priceUpper);
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Map deleteExpertById(@RequestParam(value = "id") Long id){
        Map result=expertService.deleteExpertById(id);
        return result;
    }
}
