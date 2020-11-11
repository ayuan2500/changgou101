package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.core.service.CoreService;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @ClassName CategoryController
 * @Description 商品分类控制层
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 17:37:00
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractCoreController<Category> {

    public CategoryController(CategoryService categoryService) {
        super(categoryService, Category.class);
    }
}
