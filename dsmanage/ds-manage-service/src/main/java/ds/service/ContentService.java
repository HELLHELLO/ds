package ds.service;

import ds.common.pojo.Result;
import ds.pojo.Content;

import java.util.Map;

public interface ContentService {
    public Result getContentList(Long id);
    public Result addContent(Content content);
    public Result updateContent(Content content);
    public Result delContent(Long id);
}
