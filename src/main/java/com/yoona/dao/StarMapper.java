package com.yoona.dao;

import com.yoona.entity.QueryVo;
import com.yoona.entity.Star;
import com.yoona.util.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StarMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Star record);

    Star selectByPrimaryKey(Integer sid);

    List<Star> selectAll();

    int updateByPrimaryKey(Star record);

    List<Star> selectByName(String name);

    List<Star> selectByLike(String name);

    Star selectByCondition(Star s);

    Star selectByConditions(@Param("starName")String name, @Param("movie")String movie);

    List<Star> selectSomeInfo();

    List<QueryVo> selectByQueryVo();

    int countStar();

    List<Star> showPage(@Param("start")Integer start,@Param("limit")Integer limit);
}