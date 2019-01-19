package ds.common.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class Result {
    public enum Status{success,emptyParam,somethingWrong};
    private String statu;
    private Integer code;
    private String message;
    private Object list;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public Result(Status code, String message){
        this(code,message,null);
    }

    public Result(Status code, String message, Object list){
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

    public static Result build(Status status, String msg, Object data) {
        return new Result(status, msg, data);
    }

    public static Result formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, Result.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(Status.valueOf(jsonNode.get("status").asText()), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static Result format(String json) {
        try {
            return MAPPER.readValue(json, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(Status.valueOf(jsonNode.get("status").asText()), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
