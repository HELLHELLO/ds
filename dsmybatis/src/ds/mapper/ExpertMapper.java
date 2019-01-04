package ds.mapper;

import ds.pojo.Expert;
import ds.pojo.ExpertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertMapper {
    long countByExample(ExpertExample example);

    int deleteByExample(ExpertExample example);

    int deleteByPrimaryKey(Long expert);

    int insert(Expert record);

    int insertSelective(Expert record);

    List<Expert> selectByExample(ExpertExample example);

    Expert selectByPrimaryKey(Long expert);

    int updateByExampleSelective(@Param("record") Expert record, @Param("example") ExpertExample example);

    int updateByExample(@Param("record") Expert record, @Param("example") ExpertExample example);

    int updateByPrimaryKeySelective(Expert record);

    int updateByPrimaryKey(Expert record);
}