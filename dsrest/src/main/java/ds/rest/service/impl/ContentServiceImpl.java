package ds.rest.service.impl;

import ds.mapper.ContentMapper;
import ds.pojo.Content;
import ds.pojo.ContentExample;
import ds.rest.dao.JedisClient;
import ds.rest.service.ContentService;
import ds.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ds.common.pojo.Result;
import java.util.List;
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    @Override
    public Result getContentList(Long id) {

        if (id==null){
            return new Result(Result.Status.emptyParam,"failed");
        }

        try{
            String result=jedisClient.hget(INDEX_CONTENT_REDIS_KEY,id.toString());
            if(!StringUtils.isBlank(result)){
                List<Content> list=JsonUtils.jsonToList(result,Content.class);
                return new Result(Result.Status.success,"success",list);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        Result result;
        ContentExample contentExample=new ContentExample();
        ContentExample.Criteria criteria=contentExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andCategoryIdEqualTo(id);
        List<Content> list=contentMapper.selectByExampleWithBLOBs(contentExample);
        result=new Result(Result.Status.success,"success",list);

        try{
            String cacheString= JsonUtils.objectToJson(list);
            jedisClient.hset(INDEX_CONTENT_REDIS_KEY,id.toString(),cacheString);
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
