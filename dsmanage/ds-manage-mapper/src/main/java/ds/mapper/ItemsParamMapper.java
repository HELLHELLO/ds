package ds.mapper;

import ds.pojo.ItemsParam;
import ds.pojo.ItemsParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsParamMapper {
    long countByExample(ItemsParamExample example);

    int deleteByExample(ItemsParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemsParam record);

    int insertSelective(ItemsParam record);

    List<ItemsParam> selectByExampleWithBLOBs(ItemsParamExample example);

    List<ItemsParam> selectByExample(ItemsParamExample example);

    ItemsParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemsParam record, @Param("example") ItemsParamExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemsParam record, @Param("example") ItemsParamExample example);

    int updateByExample(@Param("record") ItemsParam record, @Param("example") ItemsParamExample example);

    int updateByPrimaryKeySelective(ItemsParam record);

    int updateByPrimaryKeyWithBLOBs(ItemsParam record);

    int updateByPrimaryKey(ItemsParam record);
}