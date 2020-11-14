package com.changgou.goods.service;

import com.changgou.core.service.CoreService;
import com.changgou.goods.pojo.Template;

/****
 * @Author:admin
 * @Description:Template业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TemplateService extends CoreService<Template> {
    //根据分类id查询模板对象数据
    Template findByCategoryId(Integer categoryId);
}
