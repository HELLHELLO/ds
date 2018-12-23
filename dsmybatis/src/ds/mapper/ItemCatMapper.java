package ds.mapper;

import ds.pojo.ItemCat;
import ds.pojo.ItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemCatMapper {
    long countByExample(ItemCatExample example);

    int deleteByExample(ItemCatExample example);

    int deleteByPrimaryKey(Long catId);

    int insert(ItemCat record);

    int insertSelective(ItemCat record);

    List<ItemCat> selectByExampleWithBLOBs(ItemCatExample example);

    List<ItemCat> selectByExample(ItemCatExample example);

    ItemCat selectByPrimaryKey(Long catId);

    int updateByExampleSelective(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    int updateByExample(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    int updateByPrimaryKeySelective(ItemCat record);

    int updateByPrimaryKeyWithBLOBs(ItemCat record);

    int updateByPrimaryKey(ItemCat record);
}