package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Template;
import com.changgou.goods.service.TemplateService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/template")
@CrossOrigin
public class TemplateController extends AbstractCoreController<Template> {

    private TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        super(templateService, Template.class);
        this.templateService = templateService;
    }

    /***
     * @title findByCategoryId
     * @description 根据分类id查询模板对象数据
     * @param categoryId 分类id
     * @return entity.Result<com.changgou.goods.pojo.Template>
     * @author ayuan
     * @updateTime 2020/11/13 10:18
     */
    @GetMapping("/category/{categoryId}")
    public Result<Template> findByCategoryId(@PathVariable Integer categoryId) {
        //根据分类id查询模板对象数据
        Template template = templateService.findByCategoryId(categoryId);
        //返回结果
        return Result.ok("查询成功",template);
    }
}
