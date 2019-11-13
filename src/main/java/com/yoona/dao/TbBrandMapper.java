package com.yoona.dao;

import com.yoona.entity.TbBrand;
import com.yoona.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbBrand record);

    TbBrand selectByPrimaryKey(Long id);

    List<TbBrand> selectAll();

    int updateByPrimaryKey(TbBrand record);

    int getBrandNum();

    List<TbBrand> showPages(@Param("start") Integer start, @Param("count") Integer count);
}