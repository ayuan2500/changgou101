package com.changgou.goods.service;

import com.changgou.core.service.CoreService;
import com.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/****
 * @Author:admin
 * @Description:Brand业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BrandService extends CoreService<Brand> {
    //根据分类id查询品牌列表集合
    List<Brand> findByCategoryId(Integer categoryId);
}
