package ds.mapper;

import ds.pojo.ItemsParamItem;
import ds.pojo.ItemsParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsParamItemMapper {
    long countByExample(ItemsParamItemExample example);

    int deleteByExample(ItemsParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemsParamItem record);

    int insertSelective(ItemsParamItem record);

    List<ItemsParamItem> selectByExampleWithBLOBs(ItemsParamItemExample example);

    List<ItemsParamItem> selectByExample(ItemsParamItemExample example);

    ItemsParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemsParamItem record, @Param("example") ItemsParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemsParamItem record, @Param("example") ItemsParamItemExample example);

    int updateByExample(@Param("record") ItemsParamItem record, @Param("example") ItemsParamItemExample example);

    int updateByPrimaryKeySelective(ItemsParamItem record);

    int updateByPrimaryKeyWithBLOBs(ItemsParamItem record);

    int updateByPrimaryKey(ItemsParamItem record);
}