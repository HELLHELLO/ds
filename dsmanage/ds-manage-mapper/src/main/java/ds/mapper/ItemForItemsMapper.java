package ds.mapper;

import ds.pojo.ItemForItems;
import ds.pojo.ItemForItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemForItemsMapper {
    long countByExample(ItemForItemsExample example);

    int deleteByExample(ItemForItemsExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(ItemForItems record);

    int insertSelective(ItemForItems record);

    List<ItemForItems> selectByExample(ItemForItemsExample example);

    ItemForItems selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") ItemForItems record, @Param("example") ItemForItemsExample example);

    int updateByExample(@Param("record") ItemForItems record, @Param("example") ItemForItemsExample example);

    int updateByPrimaryKeySelective(ItemForItems record);

    int updateByPrimaryKey(ItemForItems record);
}