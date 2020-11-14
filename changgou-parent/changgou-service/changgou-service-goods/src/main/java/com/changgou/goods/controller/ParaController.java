package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.service.ParaService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/para")
@CrossOrigin
public class ParaController extends AbstractCoreController<Para> {

    private ParaService paraService;

    @Autowired
    public ParaController(ParaService paraService) {
        super(paraService, Para.class);
        this.paraService = paraService;
    }

    /***
     * @title findByCategoryId
     * @description 根据分类id查询参数对象集合
     * @param categoryId 分类id
     * @return entity.Result<java.util.List<com.changgou.goods.pojo.Para>>
     * @author ayuan
     * @updateTime 2020/11/13 10:56
     */
    @GetMapping("/category/{categoryId}")
    public Result<List<Para>> findByCategoryId(@PathVariable Integer categoryId) {
        //根据分类id查询参数对象集合
        List<Para> paraList = paraService.findByCategoryId(categoryId);
        //返回结果
        return Result.ok("查询成功",paraList);
    }
}
