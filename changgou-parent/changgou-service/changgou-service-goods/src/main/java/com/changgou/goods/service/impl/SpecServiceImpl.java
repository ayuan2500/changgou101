package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.dao.SpecMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.pojo.Spec;
import com.changgou.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import java.util.List;

/****
 * @Author:admin
 * @Description:Spec业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SpecServiceImpl extends CoreServiceImpl<Spec> implements SpecService {

    private SpecMapper specMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    public SpecServiceImpl(SpecMapper specMapper) {
        super(specMapper, Spec.class);
        this.specMapper = specMapper;
    }

    /***
     * @title findByCategoryId
     * @description 根据分类id查询规格对象集合
     * @param categoryId 分类id
     * @return java.util.List<com.changgou.goods.pojo.Spec>
     * @author ayuan
     * @updateTime 2020/11/13 10:29 
     */
    @Override
    public List<Spec> findByCategoryId(Integer categoryId) {
        //根据分类id查询分类对象数据
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        //创建规格对象
        Spec spec = new Spec();
        //设置规格对象的模板id
        spec.setTemplateId(category.getTemplateId());
        //根据模板id查询规格对象数据，并返回规格对象数据
        return specMapper.select(spec);
    }
}
