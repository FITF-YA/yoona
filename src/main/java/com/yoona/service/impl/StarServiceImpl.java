package com.yoona.service.impl;

import com.yoona.dao.StarMapper;
import com.yoona.entity.QueryVo;
import com.yoona.entity.Star;
import com.yoona.service.IStarService;
import com.yoona.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: AI
 * @Date: 2019/11/12 11:04
 * @Version: 1.0
 */
@Service(value = "StarService")
public class StarServiceImpl implements IStarService {

    @Autowired
    private StarMapper starMapper;

    @Override
    public Star getByID(Integer sid) {
        return starMapper.selectByPrimaryKey(sid);
    }

    @Override
    public Map<String, Object> add(Map<String, Object> requestBody) {
        Star star = new Star();
        Date now = new Date();
        star.setStarName(requestBody.get("star_name").toString());
        star.setStarSex(Integer.parseInt(requestBody.get("star_sex").toString()));
        star.setMovie(requestBody.get("movie").toString());
        star.setCreated(now);
        star.setUpdated(now);
        Map<String, Object> map = new HashMap<>();
        int n = starMapper.insert(star);
        if(n == 1) {
            map.put("message", "添加成功");
        } else {
            map.put("message", "添加失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteByKey(Integer sid) {
        Map<String, Object> map = new HashMap<>();
        int n = starMapper.deleteByPrimaryKey(sid);
        if(n == 1) {
            map.put("message", "删除成功");
        } else {
            map.put("message", "删除失败");
        }
        return map;
    }

    @Override
    public List<Star> getAll() {
        return starMapper.selectAll();
    }

    @Override
    public Map<String, Object> updateByKey(Star record) {
        Map<String, Object> map = new HashMap<>();
        record.setCreated(new Date());
        record.setUpdated(new Date());
        int n = starMapper.updateByPrimaryKey(record);
        if(n == 1) {
            map.put("message", "更新成功");
        } else {
            map.put("message", "更新失败");
        }
        return map;
    }

    @Override
    public Star getByCondition(Star s) {
       Star st = new Star();
       st.setStarName(s.getStarName());
       st.setMovie(s.getMovie());
       return starMapper.selectByCondition(st);

    }

    @Override
    public List<QueryVo> selectByQueryVo() {
        return starMapper.selectByQueryVo();
    }

    @Override
    public PageBean<Star> selectPage(int pageNum, int limit) {
        PageBean<Star> pageBean = new PageBean<>();
        pageBean.setPage(pageNum);
        pageBean.setLimit(limit);
        Integer total = starMapper.countStar();
        pageBean.setTotalCount(total);
        Integer nums = (int)Math.ceil((double) total/(double) limit);
        pageBean.setTotalPage(nums);
        Integer start = (pageNum  - 1)*limit;
        List<Star> lists = starMapper.showPage(start,limit);
        pageBean.setList(lists);
        return pageBean;
    }
}
