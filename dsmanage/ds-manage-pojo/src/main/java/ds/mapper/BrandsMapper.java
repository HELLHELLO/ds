package ds.mapper;

import ds.pojo.Brands;
import ds.pojo.BrandsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandsMapper {
    long countByExample(BrandsExample example);

    int deleteByExample(BrandsExample example);

    int deleteByPrimaryKey(Long brandId);

    int insert(Brands record);

    int insertSelective(Brands record);

    List<Brands> selectByExample(BrandsExample example);

    Brands selectByPrimaryKey(Long brandId);

    int updateByExampleSelective(@Param("record") Brands record, @Param("example") BrandsExample example);

    int updateByExample(@Param("record") Brands record, @Param("example") BrandsExample example);

    int updateByPrimaryKeySelective(Brands record);

    int updateByPrimaryKey(Brands record);
}