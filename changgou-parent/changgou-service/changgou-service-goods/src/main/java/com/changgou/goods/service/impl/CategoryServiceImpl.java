package com.changgou.goods.service.impl;


import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @ClassName CategoryServiceImpl
 * @Description 商品分类业务层处理
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 17:29:00
 */
@Service    //交给spring容器管理
public class CategoryServiceImpl extends CoreServiceImpl<Category> implements CategoryService {
    //定义CategoryMapper对象
    private CategoryMapper categoryMapper;
    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        super(categoryMapper, Category.class);
        //给categoryMapper对象赋值
        this.categoryMapper = categoryMapper;
    }
}
