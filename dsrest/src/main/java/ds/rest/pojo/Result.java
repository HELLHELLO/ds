package ds.rest.pojo;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public enum Status{success,emptyParam,somethingWrong};
    private String statu;
    private Integer code;
    private String message;
    private Object list;

    public Result(Status code, String message){
        this(code,message,null);
    }

    public Result(Status code,String message,Object list){
        this.list=list;
        this.code=code.ordinal();
        this.statu=code.toString();
        this.message=message;
    }

    public void setStatu(String statu){
        this.statu=statu;
    }

    public void setCode(Integer code){
        this.code=code;
    }

    public void setList(Object list){
        this.list=list;
    }

    public void setMessage(String message){
        this.message=message;
    }

    public String getStatu(){
        return this.statu;
    }

    public String getMessage(){
        return this.message;
    }

    public Integer getCode(){
        return this.code;
    }

    public Object getList(){
        return list;
    }
}
