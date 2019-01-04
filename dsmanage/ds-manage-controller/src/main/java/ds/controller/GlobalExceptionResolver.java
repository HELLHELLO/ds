package ds.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map returnTheExceptionMessage(Exception e){
        Map result=new HashMap();
        result.put("statu","failed");
        result.put("code","6");
        result.put("message","something wrong");
        result.put("detail",e.getMessage());
        return result;
    }
}
