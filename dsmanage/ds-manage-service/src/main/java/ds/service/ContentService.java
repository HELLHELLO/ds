package ds.service;

import ds.pojo.Content;

import java.util.Map;

public interface ContentService {
    public Map getContentList(Long id);
    public Map addContent(Content content);
    public Map updateContent(Content content);
    public Map delContent(Long id);
}
