package ds.mapper;

import ds.pojo.TraceManager;
import ds.pojo.TraceManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TraceManagerMapper {
    long countByExample(TraceManagerExample example);

    int deleteByExample(TraceManagerExample example);

    int deleteByPrimaryKey(Long mngId);

    int insert(TraceManager record);

    int insertSelective(TraceManager record);

    List<TraceManager> selectByExample(TraceManagerExample example);

    TraceManager selectByPrimaryKey(Long mngId);

    int updateByExampleSelective(@Param("record") TraceManager record, @Param("example") TraceManagerExample example);

    int updateByExample(@Param("record") TraceManager record, @Param("example") TraceManagerExample example);

    int updateByPrimaryKeySelective(TraceManager record);

    int updateByPrimaryKey(TraceManager record);
}