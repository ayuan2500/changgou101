package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @ClassName BrandController
 * @Description 描述
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/09 21:36:00
 */
@RestController //交给spring容器管理
@RequestMapping("/brand")
public class BrandController {
    //从spring容器ioc注入BrandService对象
    @Autowired
    private BrandService brandService;

    /***
     * @title selectAll
     * @description 查询所有品牌
     * @param
     * @return entity.Result<java.util.List<com.changgou.goods.pojo.Brand>>
     * @author ayuan
     * @updateTime 2020/11/9 21:38
     */
    @GetMapping
    public Result<List<Brand>> selectAll() {
        //调用brandService的selectAll方法获取所有品牌信息
        List<Brand> brandList = brandService.selectAll();
        //返回Result结果
        return Result.ok(brandList);
    }

    /***
     * @title findById
     * @description 根据品牌id查询品牌信息
     * @param id 商品id
     * @return entity.Result<com.changgou.goods.pojo.Brand>
     * @author ayuan
     * @updateTime 2020/11/10 8:46
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        //调用Service的findById方法根据品牌id查询品牌信息
        Brand brand = brandService.findById(id);
        //返回Result结果给调用者
        return Result.ok(brand);
    }

    /***
     * @title add
     * @description 新增品牌
     * @param brand 品牌数据对象
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/10 9:01
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        //调用brandService的add方法新增品牌
        brandService.add(brand);
        //返回Result结果给调用者
        return Result.ok(null);
    }

    /***
     * @title update
     * @description 根据品牌id修改品牌信息
     * @param brand 品牌数据对象
	 * @param id 品牌id
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/10 9:16
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Brand brand, @PathVariable Integer id) {
        //设置品牌id
        brand.setId(id);
        //调用brandService的update方法根据品牌id修改品牌信息
        brandService.update(brand);
        //返回Result结果给调用者
        return Result.ok(null);
    }

    /***
     * @title delete
     * @description 根据品牌id删除品牌数据
     * @param id 品牌id
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/10 9:23
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        //调用brandService的delete方法根据品牌id删除品牌信息
        brandService.delete(id);
        //返回Result结果给调用者
        return Result.ok(null);
    }

    /***
     * @title findList
     * @description 根据条件搜索品牌
     * @param brand 包含搜索条件的品牌数据对象
     * @return entity.Result<java.util.List<com.changgou.goods.pojo.Brand>>
     * @author ayuan
     * @updateTime 2020/11/10 10:11
     */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand) {
        //调用brandService的findList方法传入搜索条件的品牌数据对象brand根据条件搜索品牌
        List<Brand> brandList = brandService.findList(brand);
        //返回Result结果给调用者
        return Result.ok(brandList);
    }

    /***
     * @title findPage
     * @description 分页查询
     * @param page 当前页
	 * @param size 每页显示多少条
     * @return entity.Result<com.github.pagehelper.PageInfo>
     * @author ayuan
     * @updateTime 2020/11/10 10:42
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        //返回Result结果给调用者
        return Result.ok(pageInfo);
    }

    /***
     * @title findPage
     * @description 根据搜索条件分页查询
     * @param brand 包含搜索条件的品牌数据对象
     * @param page 当前页
     * @param size 每页显示多少条
     * @return com.github.pagehelper.PageInfo<com.changgou.goods.pojo.Brand>
     * @author ayuan
     * @updateTime 2020/11/10 10:57
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable  int page, @PathVariable  int size){
        //根据搜索条件分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        //返回Result结果给调用者
        return Result.ok(pageInfo);
    }
}
