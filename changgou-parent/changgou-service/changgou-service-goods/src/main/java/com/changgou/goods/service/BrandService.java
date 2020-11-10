package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/***
 * @ClassName BrandService
 * @Description 品牌接口
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/09 21:31:00
 */
public interface BrandService {
    //查询所有品牌信息
    List<Brand> selectAll();

    //根据品牌id查询品牌信息
    Brand findById(Integer id);

    //新增品牌
    void add(Brand brand);

    //根据品牌id修改品牌信息
    void update(Brand brand);

    //根据品牌id删除品牌信息
    void delete(Integer id);

    //根据条件搜索品牌
    List<Brand> findList(Brand brand);

    //分页查询
    PageInfo<Brand> findPage(int page, int size);

    //根据搜索条件分页查询
    PageInfo<Brand> findPage(Brand brand, int page, int size);
}
