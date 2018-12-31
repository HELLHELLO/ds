package ds.service.impl;

import ds.mapper.ItemPicMapper;
import ds.pojo.ItemPic;
import ds.service.PictureService;
import ds.utils.FtpUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 以后要加上一个上传者id的参数标识这个图片是谁上传的
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_ADDRESS}")
    private String ftpAdress;
    @Value("${FTP_PORT}")
    private int ftpPort;
    @Value("${FTP_USER}")
    private String ftpUser;
    @Value("${FTP_PASSWORD}")
    private String ftpPassword;
    @Value("${FTP_BASE_PATH}")
    private String ftpBasePath;
    @Value("${IMAGE_BASE_URL}")
    private String pictureBaseUrl;

    @Autowired
    private ItemPicMapper itemPicMapper;

    @Override
    public Map upLoadPicture(MultipartFile picture){
        Map resultMap=new HashMap();
        //取原始文件名
        String oldName=picture.getOriginalFilename();
        //生成新文件名
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
        String imagePath=new DateTime().toString("/yyyy/MM/dd");
        //上传到ftp服务器
        try {
            boolean result=FtpUtil.uploadFile(ftpAdress, ftpPort, ftpUser, ftpPassword, ftpBasePath,imagePath, newName, picture.getInputStream());
            if (!result){   //上传失败
                resultMap.put("statu","1");
                resultMap.put("message","upload failed");
                resultMap.put("url","");
                resultMap.put("picId","");
                return resultMap;
            }
        }
        catch (IOException ioError){    //上传文件流出现错误
            resultMap.put("statu","1");
            resultMap.put("message","uploaded file wrong");
            resultMap.put("url","");
            resultMap.put("picId","");
            return resultMap;
        }
        String picUrl=pictureBaseUrl+imagePath+"/"+newName;
        //上传成功，信息写入数据库
        ItemPic itemPic=new ItemPic();
        itemPic.setPicMaster(false);    //设定不是主图
        itemPic.setPicStatu(true);
        itemPic.setPicUrl(picUrl);
        int insertResult=itemPicMapper.insertSelective(itemPic);
        if(insertResult==0){
            resultMap.put("statu","1");
            resultMap.put("message","failed to insert to database");
            resultMap.put("url","");
            resultMap.put("picId","");
            return resultMap;
        }
        Long picId=itemPic.getPicId();  //获取插入后的图片id


        resultMap.put("statu","0");
        resultMap.put("message","success");
        resultMap.put("url",pictureBaseUrl+imagePath+"/"+newName);
        resultMap.put("picId",picId.toString());
        return resultMap;
    }
}
