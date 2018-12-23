package ds.mapper;

import ds.pojo.UserComuser;
import ds.pojo.UserComuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserComuserMapper {
    long countByExample(UserComuserExample example);

    int deleteByExample(UserComuserExample example);

    int deleteByPrimaryKey(Long comuserId);

    int insert(UserComuser record);

    int insertSelective(UserComuser record);

    List<UserComuser> selectByExample(UserComuserExample example);

    UserComuser selectByPrimaryKey(Long comuserId);

    int updateByExampleSelective(@Param("record") UserComuser record, @Param("example") UserComuserExample example);

    int updateByExample(@Param("record") UserComuser record, @Param("example") UserComuserExample example);

    int updateByPrimaryKeySelective(UserComuser record);

    int updateByPrimaryKey(UserComuser record);
}