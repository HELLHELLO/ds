package ds.controller;

import ds.common.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result returnTheExceptionMessage(Exception e){
        return new Result(Result.Status.somethingWrong,e.getMessage());
    }
}
