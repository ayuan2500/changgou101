package com.changgou.goods.service;

import com.changgou.core.service.CoreService;
import com.changgou.goods.pojo.Goods;
import com.changgou.goods.pojo.Spu;

/****
 * @Author:admin
 * @Description:Spu业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SpuService extends CoreService<Spu> {
    //保存商品的spu和sku
    void saveGoods(Goods goods);

    //根据spuId查询spu和sku集合
    Goods findGoodsById(Long spuId);

    //商品审核
    void audit(Long spuId);

    //下架商品
    void pull(Long spuId);

    //上架商品
    void put(Long spuId);

    //批量上架
    int putMany(Long[] spuIds);

    //逻辑删除商品
    void logicDeleteBySpuId(Long spuId);

    //还原商品
    void restore(Long spuId);

    //物理删除商品
    void delete(Long spuId);
}
