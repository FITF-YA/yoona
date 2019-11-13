package com.yoona.controller;


import com.yoona.entity.TbBrand;
import com.yoona.service.ITbBrandService;
import com.yoona.util.PageBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource(name = "TbBrandService")
    private ITbBrandService tbBrandService;

    @GetMapping("/getAllBrand")
    private ResponseEntity<Object> getAllBrand(){
        List<TbBrand> list = tbBrandService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getBrandByPage")
    private ResponseEntity<Object> getBrandByPage(@RequestParam("start") Integer start,@RequestParam("count") Integer count ){
        PageBean<TbBrand> pbs = tbBrandService.getPageByNum(start,count);
        return ResponseEntity.ok(pbs);
    }
}
