package ds.rest.service.impl;

import ds.common.pojo.Result;
import ds.rest.dao.JedisClient;
import ds.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JedisClient jedisClient;
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;
    @Value("${ITEM_CAT_REDIS_KEY}")
    private String ITEM_CAT_REDIS_KEY;

    @Override
    public Result syncRedisContent(Long contentCategoryId) {
        jedisClient.hdel(INDEX_CONTENT_REDIS_KEY,contentCategoryId.toString());
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result syncRedisCatTree() {
        jedisClient.del(ITEM_CAT_REDIS_KEY);
        return new Result(Result.Status.success,"success");
    }
}
