package ds.mapper;

import ds.pojo.ItemPic;
import ds.pojo.ItemPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemPicMapper {
    long countByExample(ItemPicExample example);

    int deleteByExample(ItemPicExample example);

    int deleteByPrimaryKey(Long picId);

    int insert(ItemPic record);

    int insertSelective(ItemPic record);

    List<ItemPic> selectByExample(ItemPicExample example);

    ItemPic selectByPrimaryKey(Long picId);

    int updateByExampleSelective(@Param("record") ItemPic record, @Param("example") ItemPicExample example);

    int updateByExample(@Param("record") ItemPic record, @Param("example") ItemPicExample example);

    int updateByPrimaryKeySelective(ItemPic record);

    int updateByPrimaryKey(ItemPic record);
}