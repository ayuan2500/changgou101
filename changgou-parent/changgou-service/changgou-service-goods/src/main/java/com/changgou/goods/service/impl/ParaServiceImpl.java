package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.dao.ParaMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author:admin
 * @Description:Para业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ParaServiceImpl extends CoreServiceImpl<Para> implements ParaService {

    private ParaMapper paraMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    public ParaServiceImpl(ParaMapper paraMapper) {
        super(paraMapper, Para.class);
        this.paraMapper = paraMapper;
    }

    /***
     * @title findByCategoryId
     * @description 根据分类id查询分类对象数据
     * @param categoryId 分类id
     * @return java.util.List<com.changgou.goods.pojo.Para>
     * @author ayuan
     * @updateTime 2020/11/13 10:58
     */
    @Override
    public List<Para> findByCategoryId(Integer categoryId) {
        //根据分类id查询分类对象数据
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        //创建参数对象
        Para para = new Para();
        //参数对象设置模板id
        para.setTemplateId(category.getTemplateId());
        //根据模板id查询参数对象集合
        return paraMapper.select(para);
    }
}
