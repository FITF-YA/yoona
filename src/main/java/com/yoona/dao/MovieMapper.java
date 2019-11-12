package com.yoona.dao;

import com.yoona.entity.Movie;
import java.util.List;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer mvId);

    int insert(Movie record);

    Movie selectByPrimaryKey(Integer mvId);

    List<Movie> selectAll();

    int updateByPrimaryKey(Movie record);
}