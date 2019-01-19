package ds.rest.controller;

import ds.common.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result returnTheExceptionMessage(Exception e){
        Result result=new Result(Result.Status.somethingWrong,e.getMessage());
        return result;
    }
}
