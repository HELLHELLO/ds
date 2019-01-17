package ds.mapper;

import ds.pojo.TraceMng;
import ds.pojo.TraceMngExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TraceMngMapper {
    long countByExample(TraceMngExample example);

    int deleteByExample(TraceMngExample example);

    int deleteByPrimaryKey(Long mngId);

    int insert(TraceMng record);

    int insertSelective(TraceMng record);

    List<TraceMng> selectByExampleWithBLOBs(TraceMngExample example);

    List<TraceMng> selectByExample(TraceMngExample example);

    TraceMng selectByPrimaryKey(Long mngId);

    int updateByExampleSelective(@Param("record") TraceMng record, @Param("example") TraceMngExample example);

    int updateByExampleWithBLOBs(@Param("record") TraceMng record, @Param("example") TraceMngExample example);

    int updateByExample(@Param("record") TraceMng record, @Param("example") TraceMngExample example);

    int updateByPrimaryKeySelective(TraceMng record);

    int updateByPrimaryKeyWithBLOBs(TraceMng record);

    int updateByPrimaryKey(TraceMng record);
}