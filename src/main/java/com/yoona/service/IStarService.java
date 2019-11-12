package com.yoona.service;

import com.yoona.entity.QueryVo;
import com.yoona.entity.Star;
import com.yoona.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Author: AI
 * @Date: 2019/11/12 11:02
 * @Version: 1.0
 */
public interface IStarService {

    Star getByID(Integer sid);

    Map<String, Object> add(Map<String, Object> requestBody);

    Map<String, Object> deleteByKey(Integer sid);

    List<Star> getAll();

    Map<String, Object> updateByKey(Star record);

    Star getByCondition(Star s);

    List<QueryVo> selectByQueryVo();

    PageBean<Star> selectPage(int start, int limit);



}
