package ds.service;

import ds.common.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface PictureService {
    Result upLoadPicture(MultipartFile picture);
}
