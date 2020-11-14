package com.changgou.goods.service;

import com.changgou.core.service.CoreService;
import com.changgou.goods.pojo.Spec;

import java.util.List;

/****
 * @Author:admin
 * @Description:Spec业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SpecService extends CoreService<Spec> {
    //根据分类id查询规格对象集合
    List<Spec> findByCategoryId(Integer categoryId);
}
