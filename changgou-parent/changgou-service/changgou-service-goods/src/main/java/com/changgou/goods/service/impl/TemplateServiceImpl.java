package com.changgou.goods.service.impl;


import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.TemplateMapper;
import com.changgou.goods.pojo.Template;
import com.changgou.goods.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @ClassName TemplateServiceImpl
 * @Description 模板业务层处理
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:11:00
 */
@Service    //交给spring容器管理
public class TemplateServiceImpl extends CoreServiceImpl<Template> implements TemplateService {
    //定义TemplateMapper对象
    private TemplateMapper templateMapper;

    @Autowired
    public TemplateServiceImpl(TemplateMapper templateMapper) {
        super(templateMapper, Template.class);
        //给TemplateMapper对象赋值
        this.templateMapper = templateMapper;
    }
}
