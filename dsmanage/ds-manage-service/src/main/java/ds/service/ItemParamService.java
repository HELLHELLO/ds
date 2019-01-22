package ds.service;

import java.util.Map;

public interface ItemParamService {
    public Map getItemParamServiceByCatId(Long catId);
    public Map addItemParamServiceByCatId(Long catId,String paramData);
}
