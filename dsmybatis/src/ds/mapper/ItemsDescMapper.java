package ds.mapper;

import ds.pojo.ItemsDesc;
import ds.pojo.ItemsDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsDescMapper {
    long countByExample(ItemsDescExample example);

    int deleteByExample(ItemsDescExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemsDesc record);

    int insertSelective(ItemsDesc record);

    List<ItemsDesc> selectByExampleWithBLOBs(ItemsDescExample example);

    List<ItemsDesc> selectByExample(ItemsDescExample example);

    ItemsDesc selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemsDesc record, @Param("example") ItemsDescExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemsDesc record, @Param("example") ItemsDescExample example);

    int updateByExample(@Param("record") ItemsDesc record, @Param("example") ItemsDescExample example);

    int updateByPrimaryKeySelective(ItemsDesc record);

    int updateByPrimaryKeyWithBLOBs(ItemsDesc record);

    int updateByPrimaryKey(ItemsDesc record);
}