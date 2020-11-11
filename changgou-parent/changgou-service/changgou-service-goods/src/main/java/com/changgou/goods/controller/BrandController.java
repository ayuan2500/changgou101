package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/***
 * @ClassName BrandController
 * @Description 品牌控制层
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/09 21:36:00
 */
@RestController	//交给spring容器管理
@RequestMapping("/brand")	//设置请求路径
public class BrandController extends AbstractCoreController<Brand> {

    @Autowired	//从spring容器获取ioc注入brandService对象
    public BrandController(BrandService brandService) {
        super(brandService, Brand.class);
    }
}