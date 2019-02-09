package ds.mapper;

import ds.pojo.TraceAccess;
import ds.pojo.TraceAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TraceAccessMapper {
    long countByExample(TraceAccessExample example);

    int deleteByExample(TraceAccessExample example);

    int deleteByPrimaryKey(Long traceAccessId);

    int insert(TraceAccess record);

    int insertSelective(TraceAccess record);

    List<TraceAccess> selectByExample(TraceAccessExample example);

    TraceAccess selectByPrimaryKey(Long traceAccessId);

    int updateByExampleSelective(@Param("record") TraceAccess record, @Param("example") TraceAccessExample example);

    int updateByExample(@Param("record") TraceAccess record, @Param("example") TraceAccessExample example);

    int updateByPrimaryKeySelective(TraceAccess record);

    int updateByPrimaryKey(TraceAccess record);
}