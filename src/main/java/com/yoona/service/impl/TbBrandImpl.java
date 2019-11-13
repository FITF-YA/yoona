package com.yoona.service.impl;

import com.yoona.dao.TbBrandMapper;
import com.yoona.entity.TbBrand;
import com.yoona.service.ITbBrandService;
import com.yoona.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service(value = "TbBrandService")
public class TbBrandImpl implements ITbBrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> getAll() {
        return tbBrandMapper.selectAll();
    }

    @Override
    public PageBean<TbBrand> getPageByNum(Integer start, Integer count) {
        PageBean pb = new PageBean();
        pb.setPage(start);
        pb.setLimit(count);

        int totalCount = tbBrandMapper.getBrandNum();
        pb.setTotalCount(totalCount);

        int totalPage = (int)Math.ceil((double)totalCount/(double)count);
        pb.setTotalPage(totalPage);
        List<TbBrand> lists = tbBrandMapper.showPages(start,count);
        pb.setList(lists);

        return pb;
    }
}
