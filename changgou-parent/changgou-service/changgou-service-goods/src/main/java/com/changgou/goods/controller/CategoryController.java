package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
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
@RequestMapping("/category")
@CrossOrigin
public class CategoryController extends AbstractCoreController<Category> {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        super(categoryService, Category.class);
        this.categoryService = categoryService;
    }

    /***
     * @title findByParentId
     * @description 根据父Id查询分类对象（可实现查询一级、二级、三级菜单）
     * @param parentId 父Id
     * @return entity.Result<java.util.List<com.changgou.goods.pojo.Category>>
     * @author ayuan
     * @updateTime 2020/11/13 8:52
     */
    @GetMapping("/list/{parentId}")
    public Result<List<Category>> findByParentId(@PathVariable Integer parentId) {
        List<Category> categoryList = categoryService.findByParentId(parentId);
        return Result.ok("查询成功",categoryList);
    }
}
