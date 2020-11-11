package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Template;
import com.changgou.goods.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @ClassName TemplateController
 * @Description 模板控制层
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:14:00
 */
@RestController
@RequestMapping("/template")
public class TemplateController extends AbstractCoreController<Template> {

    @Autowired
    public TemplateController(TemplateService templateService) {
        super(templateService, Template.class);
    }
}
