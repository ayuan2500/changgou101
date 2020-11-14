package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Spec;
import com.changgou.goods.service.SpecService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/spec")
@CrossOrigin
public class SpecController extends AbstractCoreController<Spec> {

    private SpecService specService;

    @Autowired
    public SpecController(SpecService specService) {
        super(specService, Spec.class);
        this.specService = specService;
    }

    /***
     * @title findByCategoryId
     * @description 根据分类id查询分类对象数据
     * @param categoryId 分类id
     * @return entity.Result<java.util.List<com.changgou.goods.pojo.Spec>>
     * @author ayuan
     * @updateTime 2020/11/13 10:38
     */
    @GetMapping("/category/{categoryId}")
    public Result<List<Spec>> findByCategoryId(@PathVariable Integer categoryId) {
        //根据分类id查询分类对象数据
        List<Spec> specList = specService.findByCategoryId(categoryId);
        //返回结果
        return Result.ok("查询成功",specList);
    }
}
