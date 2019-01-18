package ds.rest.service.impl;

import ds.mapper.ContentMapper;
import ds.pojo.Content;
import ds.pojo.ContentExample;
import ds.rest.pojo.Result;
import ds.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public Result getContentList(Long id) {
        Result result;
        if (id==null){
            return new Result(Result.Status.emptyParam,"failed");
        }
        ContentExample contentExample=new ContentExample();
        ContentExample.Criteria criteria=contentExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andCategoryIdEqualTo(id);
        List<Content> list=contentMapper.selectByExampleWithBLOBs(contentExample);
        result=new Result(Result.Status.success,"success",list);
        return result;
    }
}
