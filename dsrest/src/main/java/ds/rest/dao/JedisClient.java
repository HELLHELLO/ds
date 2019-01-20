package ds.rest.dao;

import org.springframework.scheduling.support.SimpleTriggerContext;

public interface JedisClient {
    public String get(String key);
    public String set(String key,String value);
    public String hget(String hkey,String key);
    public Long hset(String hkey, String key, String value);
    public Long incr(String key);
    public Long decr(String key);
    public Long ttl(String key);
    public Long expire(String key,Integer second);
}
