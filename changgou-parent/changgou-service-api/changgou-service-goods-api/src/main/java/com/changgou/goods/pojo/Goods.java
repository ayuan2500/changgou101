package com.changgou.goods.pojo;

import java.io.Serializable;
import java.util.List;

/***
 * @ClassName Goods
 * @Description 商品组合实体类，一个SPU对应多个SKU
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/13 11:04:00
 */
public class Goods implements Serializable {
    //SPU
    private Spu spu;
    //SKU集合
    private List<Sku> skuList;

    @Override
    public String toString() {
        return "Goods{" +
                "spu=" + spu +
                ", skuList=" + skuList +
                '}';
    }

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
