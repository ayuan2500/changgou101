package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author:admin
 * @Description:Category业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class CategoryServiceImpl extends CoreServiceImpl<Category> implements CategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        super(categoryMapper, Category.class);
        this.categoryMapper = categoryMapper;
    }

    /***
     * @title findByParentId
     * @description 根据父Id查询分类对象（可实现查询一级、二级、三级菜单）
     * @param parentId 父Id
     * @return java.util.List<com.changgou.goods.pojo.Category>
     * @author ayuan
     * @updateTime 2020/11/13 9:15
     */
    @Override
    public List<Category> findByParentId(Integer parentId) {
        //创建分类对象，设置parentId
        Category category = new Category();
        category.setParentId(parentId);
        //根据父Id查询分类（可实现查询一级、二级、三级菜单）
        List<Category> categoryList =  categoryMapper.select(category);
        //返回结果
        return categoryList;
    }
}
