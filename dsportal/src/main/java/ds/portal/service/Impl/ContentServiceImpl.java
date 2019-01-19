package ds.portal.service.Impl;

import com.alibaba.druid.support.json.JSONUtils;
import ds.common.pojo.Result;
import ds.pojo.Content;
import ds.portal.service.ContentService;
import ds.utils.HttpClientUtil;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;

    @Value("${REST_INDEX_AD_URL}")
    private String REST_INDEX_AD_URL;

    @Value("${HEIGHT}")
    private Integer HEIGHT;
    @Value("${WIDTH}")
    private Integer WIDTH;
    @Value("${HEIGHTB}")
    private Integer HEIGHTB;
    @Value("${WIDTHB}")
    private Integer WIDTHB;

    @Override
    public String getContentList() {
        String result=HttpClientUtil.doGet(REST_BASE_URL+REST_INDEX_AD_URL);
        try {
            Result pojoResult=Result.formatToList(result, Content.class);
            List<Content> list=(List<Content>)pojoResult.getList();
            List<Map> resultList=new ArrayList<Map>();

            for (Content content:list) {
                Map map=new HashMap();
                map.put("src",content.getPic());
                map.put("height",HEIGHT);
                map.put("width",WIDTH);
                map.put("srcB",content.getPic2());
                map.put("heightB",HEIGHTB);
                map.put("widthB",WIDTHB);
                map.put("alt",content.getSubTitle());
                map.put("herf",content.getUrl());
                resultList.add(map);
                return JSONUtils.toJSONString(resultList);
            }
        }catch(Exception e){
            //TODO:处理错误
            e.printStackTrace();
        }
        return null;
    }
}
