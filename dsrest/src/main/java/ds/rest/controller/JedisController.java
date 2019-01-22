package ds.rest.controller;

import ds.common.pojo.Result;
import ds.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//用于缓存同步
@Controller
@RequestMapping("/cache/sync")
public class JedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/content/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result contentRedisSync(@PathVariable(value = "id") Long contentCategoryId){
        return redisService.syncRedisContent(contentCategoryId);
    }

    @RequestMapping(value = "/cat",method = RequestMethod.GET)
    @ResponseBody
    public Result catTreeSync(){
        return redisService.syncRedisCatTree();
    }
}
