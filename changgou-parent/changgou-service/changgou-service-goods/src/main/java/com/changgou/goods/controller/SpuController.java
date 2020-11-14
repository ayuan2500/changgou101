package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.dao.SpuMapper;
import com.changgou.goods.pojo.Goods;
import com.changgou.goods.pojo.Spu;
import com.changgou.goods.service.SpuService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/spu")
@CrossOrigin
public class SpuController extends AbstractCoreController<Spu> {

    private SpuService spuService;

    @Autowired
    public SpuController(SpuService spuService) {
        super(spuService, Spu.class);
        this.spuService = spuService;
    }

    /***
     * @title saveGoods
     * @description 保存spu和sku
     * @param goods 包含spu和sku的组合对象数据
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/13 11:46
     */
    @PostMapping("/save")
    public Result saveGoods(@RequestBody Goods goods) {
        spuService.saveGoods(goods);
        return Result.ok("保存成功",null);
    }

    /***
     * @title findGoodsById
     * @description 根据spuId查询spu和sku集合
     * @param spuId spuId
     * @return entity.Result<com.changgou.goods.pojo.Goods>
     * @author ayuan
     * @updateTime 2020/11/13 16:27
     */
    @GetMapping("/goods/{spuId}")
    public Result<Goods> findGoodsById(@PathVariable Long spuId) {
        //根据spuId查询spu和sku集合
        Goods goods = spuService.findGoodsById(spuId);
        //返回结果
        return Result.ok("查询成功",goods);
    }

    /***
     * @title audit
     * @description 商品审核
     * @param spuId spuId
     * @return void
     * @author ayuan
     * @updateTime 2020/11/13 17:42
     */
    @PutMapping("/audit/{spuId}")
    public Result audit(@PathVariable Long spuId) {
        //调用方法进行审核
        spuService.audit(spuId);
        //返回结果
        return Result.ok("审核成功",null);
    }

    /***
     * @title pull
     * @description 下架商品
     * @param spuId spuId
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/13 18:20
     */
    @PutMapping("/pull/{spuId}")
    public Result pull(@PathVariable Long spuId) {
        //下架商品
        spuService.pull(spuId);
        //返回结果
        return Result.ok("下架成功",null);
    }

    /***
     * @title put
     * @description 上架商品
     * @param spuId spuId
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/13 18:20
     */
    @PutMapping("/put/{spuId}")
    public Result put(@PathVariable Long spuId) {
        //上架商品
        spuService.put(spuId);
        //返回结果
        return Result.ok("上架成功",null);
    }

    /***
     * @title putMany
     * @description 批量上架
     * @param spuIds spuIds集合
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/13 19:39
     */
    @PutMapping("/put/many")
    public Result putMany(@RequestBody Long[] spuIds){
        //调用方法批量上架
        int count = spuService.putMany(spuIds);
        //返回结果
        return Result.ok("上架"+count+"个商品",null);
    }

    /***
     * @title logicDelete
     * @description 逻辑删除商品
     * @param spuId spuId
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/13 19:59
     */
    @DeleteMapping("/logic/{spuId}")
    public Result logicDelete(@PathVariable Long spuId) {
        //调用方法逻辑删除商品
        spuService.logicDeleteBySpuId(spuId);
        //返回结果
        return Result.ok("删除成功，可在商品回收站恢复",null);
    }

    /***
     * @title restore
     * @description 还原商品
     * @param spuId spuId
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/13 20:04
     */
    @PutMapping("/restore/{spuId}")
    public Result restore(@PathVariable Long spuId) {
        //调用方法还原商品
        spuService.restore(spuId);
        //返回结果
        return Result.ok("商品恢复成功",null);
    }

    /***
     * @title delete
     * @description 物理删除商品
     * @param spuId spuId
     * @return entity.Result
     * @author ayuan
     * @updateTime 2020/11/13 20:14
     */
    @DeleteMapping("/delete/{spuId}")
    public Result delete(@PathVariable Long spuId) {
        //调用方法删除商品
        spuService.delete(spuId);
        //返回结果
        return Result.ok("该商品已永久删除",null);
    }
}
