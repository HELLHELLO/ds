package ds.rest.service;

import ds.common.pojo.Result;

public interface RedisService {

    public Result syncRedisContent(Long contentCategoryId);
    public Result syncRedisCatTree();
}
