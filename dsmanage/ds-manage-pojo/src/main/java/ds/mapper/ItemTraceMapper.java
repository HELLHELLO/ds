package ds.mapper;

import ds.pojo.ItemTrace;
import ds.pojo.ItemTraceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemTraceMapper {
    long countByExample(ItemTraceExample example);

    int deleteByExample(ItemTraceExample example);

    int deleteByPrimaryKey(Long traceId);

    int insert(ItemTrace record);

    int insertSelective(ItemTrace record);

    List<ItemTrace> selectByExampleWithBLOBs(ItemTraceExample example);

    List<ItemTrace> selectByExample(ItemTraceExample example);

    ItemTrace selectByPrimaryKey(Long traceId);

    int updateByExampleSelective(@Param("record") ItemTrace record, @Param("example") ItemTraceExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemTrace record, @Param("example") ItemTraceExample example);

    int updateByExample(@Param("record") ItemTrace record, @Param("example") ItemTraceExample example);

    int updateByPrimaryKeySelective(ItemTrace record);

    int updateByPrimaryKeyWithBLOBs(ItemTrace record);

    int updateByPrimaryKey(ItemTrace record);
}