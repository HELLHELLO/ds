package ds.rest.controller;

import ds.common.pojo.Result;
import ds.rest.service.ItemCatRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/itemcat")
@Controller
public class ItemCatRestController {
    @Autowired
    private ItemCatRestService itemCatRestService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object getCatList(@RequestParam(value="callback",required = false) String callback){
        Result catResult=itemCatRestService.getItemCatList();
        /**ObjectMapper objectMapper=new ObjectMapper();
        String json="";
        try {
            json = objectMapper.writeValueAsString(catResult);
        }catch (JsonProcessingException e) {
            json = "";
        }
        String result=callback+'('+json+')';
        return result;
        //return catResult;*/
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(catResult);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
