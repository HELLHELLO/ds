package ds.service.impl;

import ds.common.pojo.Result;
import ds.mapper.ContentMapper;
import ds.mapper.ItemPicMapper;
import ds.pojo.*;
import ds.service.ContentService;
import ds.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private ItemPicMapper itemPicMapper;

    @Value("${REST_BASE_ADDR}")
    private String REST_BASE_ADDR;
    @Value("${REDIS_SERVICE_ADDR}")
    private String REDIS_SERVICE_ADDR;
    @Value("${REDIS_CONTENT_ADDR}")
    private String REDIS_CONTENT_ADDR;

    @Override
    public Result getContentList(Long id) {
        if(id==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }

        ContentExample contentExample=new ContentExample();
        ContentExample.Criteria criteria=contentExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andCategoryIdEqualTo(id);
        List<Content> list=contentMapper.selectByExample(contentExample);
        return new Result(Result.Status.success,"success",list);

    }

    @Override
    public Result addContent(Content content) {
        //检查参数
        if(content.getCategoryId()==null){
            return new Result(Result.Status.emptyParam,"empty  category id");
        }

        content.setId(null);
        int num=contentMapper.insertSelective(content);
        try {
            HttpClientUtil.doGet(REST_BASE_ADDR + REDIS_SERVICE_ADDR + REDIS_CONTENT_ADDR + content.getCategoryId().toString());
        }catch(Exception e){
            e.printStackTrace();
        }


        if (num==0){
            return new Result(Result.Status.somethingWrong,"fail to insert");
        }else{
            return new Result(Result.Status.success,"success");
        }
    }

    @Override
    public Result updateContent(Content content) {
        if (content.getId()==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }
        int num=contentMapper.updateByPrimaryKeyWithBLOBs(content);
        try {
            HttpClientUtil.doGet(REST_BASE_ADDR + REDIS_SERVICE_ADDR + REDIS_CONTENT_ADDR + content.getCategoryId().toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        if (num==0){
            return new Result(Result.Status.somethingWrong,"fail to insert");
        }else{
            return new Result(Result.Status.success,"success");
        }
    }

    @Override
    public Result delContent(Long id) {
        if (id==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }

        //删除图片
        ItemPic itemPic=new ItemPic();
        itemPic.setValued(false);

        Content delCon=contentMapper.selectByPrimaryKey(id);
        String pic=delCon.getPic();
        String pic2=delCon.getPic2();
        List<String> list=new ArrayList<String>();
        list.add(pic);
        list.add(pic2);
        ItemPicExample itemPicExample=new ItemPicExample();
        ItemPicExample.Criteria criteria=itemPicExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andPicUrlIn(list);
        itemPicMapper.updateByExampleSelective(itemPic,itemPicExample);

        //删除内容
        Content content=new Content();

        content.setValued(false);
        content.setId(id);

        contentMapper.updateByPrimaryKeySelective(content);
        try {
            HttpClientUtil.doGet(REST_BASE_ADDR + REDIS_SERVICE_ADDR + REDIS_CONTENT_ADDR + content.getCategoryId().toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Result(Result.Status.success,"success");
    }
}
