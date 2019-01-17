package ds.service.impl;

import ds.mapper.ContentMapper;
import ds.mapper.ItemPicMapper;
import ds.pojo.*;
import ds.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Map getContentList(Long id) {
        Map result=new HashMap();
        if(id==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","empty id");
            result.put("list",null);
            return result;
        }

        ContentExample contentExample=new ContentExample();
        ContentExample.Criteria criteria=contentExample.createCriteria();
        criteria.andValuedEqualTo(true);
        criteria.andCategoryIdEqualTo(id);
        List<Content> list=contentMapper.selectByExample(contentExample);

        result.put("statu","failed");
        result.put("code","1");
        result.put("message","empty id");
        result.put("list",list);
        return result;

    }

    @Override
    public Map addContent(Content content) {
        Map result=new HashMap();
        //检查参数
        if(content.getCategoryId()==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","empty category id");
            return result;
        }

        content.setId(null);
        int num=contentMapper.insertSelective(content);
        if (num==0){
            result.put("statu","failed");
            result.put("code","2");
            result.put("message","fail to insert");
            return result;
        }else{
            result.put("statu","success");
            result.put("code","0");
            result.put("message","add success");
            return result;
        }
    }

    @Override
    public Map updateContent(Content content) {
        Map result=new HashMap();
        int num=contentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (num==0){
            result.put("statu","failed");
            result.put("code","2");
            result.put("message","fail to insert");
            return result;
        }else{
            result.put("statu","success");
            result.put("code","0");
            result.put("message","add success");
            return result;
        }
    }

    @Override
    public Map delContent(Long id) {
        Map result=new HashMap();
        if (id==null){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","empty id");
            return result;
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
        result.put("statu","success");
        result.put("code","0");
        result.put("message","delete success");
        return result;
    }
}
