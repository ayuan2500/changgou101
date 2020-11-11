package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @ClassName BrandServiceImpl
 * @Description 品牌业务处理
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/09 21:31:00
 */
@Service	//交给spring容器管理
public class BrandServiceImpl extends CoreServiceImpl<Brand> implements BrandService {

    private BrandMapper brandMapper;

    @Autowired	//从spring容器获取ioc注入brandMapper对象
    public BrandServiceImpl(BrandMapper brandMapper) {
        super(brandMapper, Brand.class);
        this.brandMapper=brandMapper;
    }
}