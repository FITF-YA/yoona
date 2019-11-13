package com.yoona.service;

import com.yoona.entity.TbBrand;
import com.yoona.util.PageBean;

import java.util.List;

public interface ITbBrandService {
    List<TbBrand> getAll();
    PageBean<TbBrand> getPageByNum(Integer start,Integer count);
}
