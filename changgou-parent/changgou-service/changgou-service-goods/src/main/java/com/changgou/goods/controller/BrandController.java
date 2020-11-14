package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController extends AbstractCoreController<Brand> {

    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        super(brandService, Brand.class);
        this.brandService = brandService;
    }

    /***
     * @title findByCategoryId
     * @description 根据分类id查询品牌列表集合
     * @param categoryId 分类id
     * @return entity.Result<java.util.List<com.changgou.goods.pojo.Brand>>
     * @author ayuan
     * @updateTime 2020/11/13 9:51
     */
    @GetMapping("/category/{categoryId}")
    public Result<List<Brand>> findByCategoryId(@PathVariable Integer categoryId ) {
        //根据分类id查询品牌列表集合
        List<Brand> brandList = brandService.findByCategoryId(categoryId);
        return Result.ok("查询成功",brandList);
    }
}
