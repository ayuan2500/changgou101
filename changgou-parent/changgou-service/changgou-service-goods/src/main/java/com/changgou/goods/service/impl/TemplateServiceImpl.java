package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.TemplateMapper;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.pojo.Template;
import com.changgou.goods.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @Author:admin
 * @Description:Template业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TemplateServiceImpl extends CoreServiceImpl<Template> implements TemplateService {

    private TemplateMapper templateMapper;

    @Autowired
    public TemplateServiceImpl(TemplateMapper templateMapper) {
        super(templateMapper, Template.class);
        this.templateMapper = templateMapper;
    }

    /***
     * @title findByCategoryId
     * @description 根据分类id查询模板对象数据
     * @param categoryId 分类id
     * @return com.changgou.goods.pojo.Template
     * @author ayuan
     * @updateTime 2020/11/13 10:13
     */
    @Override
    public Template findByCategoryId(Integer categoryId) {
        //根据分类id查询模板对象数据
        return templateMapper.selectByPrimaryKey(categoryId);
    }
}
