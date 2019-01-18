package ds.rest.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import ds.rest.pojo.Result;
import ds.rest.service.ItemCatRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

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
