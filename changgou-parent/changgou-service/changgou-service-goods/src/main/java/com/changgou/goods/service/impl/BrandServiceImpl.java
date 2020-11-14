package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author:admin
 * @Description:Brand业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BrandServiceImpl extends CoreServiceImpl<Brand> implements BrandService {

    private BrandMapper brandMapper;

    @Autowired
    public BrandServiceImpl(BrandMapper brandMapper) {
        super(brandMapper, Brand.class);
        this.brandMapper = brandMapper;
    }

    /***
     * @title findByCategoryId
     * @description 根据分类id查询品牌对象集合
     * @param categoryId 分类id
     * @return java.util.List<com.changgou.goods.pojo.Brand>
     * @author ayuan
     * @updateTime 2020/11/13 9:22
     */
    @Override
    public List<Brand> findByCategoryId(Integer categoryId) {
        //根据分类id查询品牌列表集合
        return brandMapper.findByCategoryId(categoryId);
    }
}
