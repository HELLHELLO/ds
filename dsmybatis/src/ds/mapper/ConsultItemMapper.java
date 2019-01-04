package ds.mapper;

import ds.pojo.ConsultItem;
import ds.pojo.ConsultItemExample;
import ds.pojo.ConsultItemWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultItemMapper {
    long countByExample(ConsultItemExample example);

    int deleteByExample(ConsultItemExample example);

    int deleteByPrimaryKey(Long consultId);

    int insert(ConsultItemWithBLOBs record);

    int insertSelective(ConsultItemWithBLOBs record);

    List<ConsultItemWithBLOBs> selectByExampleWithBLOBs(ConsultItemExample example);

    List<ConsultItem> selectByExample(ConsultItemExample example);

    ConsultItemWithBLOBs selectByPrimaryKey(Long consultId);

    int updateByExampleSelective(@Param("record") ConsultItemWithBLOBs record, @Param("example") ConsultItemExample example);

    int updateByExampleWithBLOBs(@Param("record") ConsultItemWithBLOBs record, @Param("example") ConsultItemExample example);

    int updateByExample(@Param("record") ConsultItem record, @Param("example") ConsultItemExample example);

    int updateByPrimaryKeySelective(ConsultItemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ConsultItemWithBLOBs record);

    int updateByPrimaryKey(ConsultItem record);
}