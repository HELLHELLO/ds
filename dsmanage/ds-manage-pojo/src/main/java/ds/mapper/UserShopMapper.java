package ds.mapper;

import ds.pojo.UserShop;
import ds.pojo.UserShopExample;
import ds.pojo.UserShopWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserShopMapper {
    long countByExample(UserShopExample example);

    int deleteByExample(UserShopExample example);

    int deleteByPrimaryKey(Long shopId);

    int insert(UserShopWithBLOBs record);

    int insertSelective(UserShopWithBLOBs record);

    List<UserShopWithBLOBs> selectByExampleWithBLOBs(UserShopExample example);

    List<UserShop> selectByExample(UserShopExample example);

    UserShopWithBLOBs selectByPrimaryKey(Long shopId);

    int updateByExampleSelective(@Param("record") UserShopWithBLOBs record, @Param("example") UserShopExample example);

    int updateByExampleWithBLOBs(@Param("record") UserShopWithBLOBs record, @Param("example") UserShopExample example);

    int updateByExample(@Param("record") UserShop record, @Param("example") UserShopExample example);

    int updateByPrimaryKeySelective(UserShopWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserShopWithBLOBs record);

    int updateByPrimaryKey(UserShop record);
}