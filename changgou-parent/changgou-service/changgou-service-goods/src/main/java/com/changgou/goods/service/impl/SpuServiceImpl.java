package com.changgou.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.dao.SkuMapper;
import com.changgou.goods.dao.SpuMapper;
import com.changgou.goods.pojo.*;
import com.changgou.goods.service.SpuService;
import entity.IdWorker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/****
 * @Author:admin
 * @Description:Spu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SpuServiceImpl extends CoreServiceImpl<Spu> implements SpuService {

    private SpuMapper spuMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    public SpuServiceImpl(SpuMapper spuMapper) {
        super(spuMapper, Spu.class);
        this.spuMapper = spuMapper;
    }

    @Override
    public void saveGoods(Goods goods) {
        //获取spu
        Spu spu = goods.getSpu();
        //判断spuId是否为空
        if (spu.getId() == null) {
            //为空，新增spu
            //生成Id设置spuId
            spu.setId(idWorker.nextId());
            //保存spu
            spuMapper.insertSelective(spu);
        } else {
            //不为空，修改spu
            spuMapper.updateByPrimaryKey(spu);
            //创建sku对象
            Sku sku = new Sku();
            //设置sku对象的spuId
            sku.setSpuId(sku.getSpuId());
            //调用mapper方法传入sku，根据spuId删除对应的sku
            skuMapper.delete(sku);
        }

        //增加sku
        //获取保存时间
        Date date = new Date();
        //根据三级分类id查询分类对象数据
        Category category = categoryMapper.selectByPrimaryKey(spu.getCategory3Id());
        //根据品牌id查询品牌对象数据
        Brand brand = brandMapper.selectByPrimaryKey(spu.getBrandId());
        //获取sku集合
        List<Sku> skuList = goods.getSkuList();
        //循环将数据加入到数据库
        for (Sku sku : skuList) {
            //构造sku名称，采用spu+规格值组装
            if (StringUtils.isEmpty(sku.getSpec())) {
                //如果spec为空，则赋值为{}
                sku.setSpec("{}");
            }
            //获取Spu的名字
            String name = spu.getName();
            //将规格转换成Map
            Map<String,String> specMap = JSON.parseObject(sku.getSpec(), Map.class);
            //循环组装Sku的名字
            for (Map.Entry<String, String> entry : specMap.entrySet()) {
                name+="  "+entry.getValue();
            }
            sku.setName(name);

            //ID
            sku.setId(idWorker.nextId());
            //SpuId
            sku.setSpuId(spu.getId());
            //创建日期
            sku.setCreateTime(date);
            //修改日期
            sku.setUpdateTime(date);
            //商品分类ID
            sku.setCategoryId(spu.getCategory3Id());
            //分类名字
            sku.setCategoryName(category.getName());
            //品牌名字
            sku.setBrandName(brand.getName());
            //保存sku
            skuMapper.insertSelective(sku);
        }
    }

    @Override
    public Goods findGoodsById(Long spuId) {
        //查询spu
        Spu spu = spuMapper.selectByPrimaryKey(spuId);

        //查询List<Sku>
        //创建sku对象
        Sku sku = new Sku();
        //设置sku对象的spuId
        sku.setSpuId(spuId);
        //调用mapper的方法查询sku集合
        List<Sku> skuList = skuMapper.select(sku);
        //封装成goods
        Goods goods = new Goods();
        //goods设置spu
        goods.setSpu(spu);
        //goods设置sku
        goods.setSkuList(skuList);
        //返回goods
        return goods;
    }

    /***
     * @title audit
     * @description 商品审核
     * @param spuId spuId
     * @return void
     * @author ayuan
     * @updateTime 2020/11/13 17:42
     */
    @Override
    public void audit(Long spuId) {
        //判断商品是否被删除
        Spu spu = getSpu(spuId);
        //修改审核状态为1
        spu.setStatus("1"); //审核通过
        //调用方法根据spuId修改数据库的spu数据
        spuMapper.updateByPrimaryKeySelective(spu);
    }

    private Spu getSpu(Long spuId) {
        //根据spuId查询spu商品
        Spu spu = spuMapper.selectByPrimaryKey(spuId);
        //判断spu商品是否已被删除
        if (spu.getIsDelete().equalsIgnoreCase("1")) {
            throw new RuntimeException("该商品已经删除");
        }
        return spu;
    }

    /***
     * @title pull
     * @description 下架商品
     * @param spuId spId
     * @return void
     * @author ayuan
     * @updateTime 2020/11/13 18:04
     */
    @Override
    public void pull(Long spuId) {
        //判断商品是否被删除
        Spu spu = getSpu(spuId);
        //设置商品为下架状态
        spu.setIsMarketable("0");
        //调用方法根据spuId修改数据库的spu数据
        spuMapper.updateByPrimaryKeySelective(spu);
    }

    /***
     * @title put
     * @description 上架商品
     * @param spuId spId
     * @return void
     * @author ayuan
     * @updateTime 2020/11/13 18:05
     */
    @Override
    public void put(Long spuId) {
        //判断商品是否被删除
        Spu spu = getSpu(spuId);
        //设置商品为上架状态
        spu.setIsMarketable("1");
        //调用方法根据spuId修改数据库的spu数据
        spuMapper.updateByPrimaryKeySelective(spu);
    }

    /***
     * @title putMany
     * @description 批量上架
     * @param spuIds spuIds集合
     * @return int
     * @author ayuan
     * @updateTime 2020/11/13 19:39
     */
    @Override
    public int putMany(Long[] spuIds) {
        //创建spu对象
        Spu spu = new Spu();
        //修改上架状态为1
        spu.setIsMarketable("1");
        //批量修改
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        //将id添加到条件中
        criteria.andIn("id", Arrays.asList(spuIds));
        //下架
        criteria.andEqualTo("isMarketable","0");
        //审核通过的
        criteria.andEqualTo("status","1");
        //未被删除的
        criteria.andEqualTo("isDelete","0");
        return spuMapper.updateByExampleSelective(spu,example);
    }

    /***
     * @title logicDeleteBySpuId
     * @description 逻辑删除商品
     * @param spuId spuId
     * @return void
     * @author ayuan
     * @updateTime 2020/11/13 19:51
     */
    @Override
    public void logicDeleteBySpuId(Long spuId) {
        //根据spuId查询spu对象数据
        Spu spu = spuMapper.selectByPrimaryKey(spuId);
        //判断是否是下架商品，需要先下架再删除
        if (!spu.getIsMarketable().equalsIgnoreCase("0")) {
            throw new RuntimeException("必须先下架再删除");
        }
        //设置商品为逻辑删除
        spu.setIsDelete("1");
        //设置商品为未审核状态
        spu.setStatus("0");
        //调用方法根据spuId更新数据库的spu数据
        spuMapper.updateByPrimaryKeySelective(spu);
    }

    /***
     * @title restore
     * @description 还原商品
     * @param spuId spuId
     * @return void
     * @author ayuan
     * @updateTime 2020/11/13 20:02
     */
    @Override
    public void restore(Long spuId) {
        //根据spuId查询spu对象数据
        Spu spu = spuMapper.selectByPrimaryKey(spuId);
        //判断是否是已删除的商品
        if (!spu.getIsDelete().equalsIgnoreCase("1")) {
            throw new RuntimeException("商品未被删除");
        }
        //设置商品为未删除状态
        spu.setIsDelete("0");
        //设置商品为未审核状态
        spu.setStatus("0");
        //调用方法根据spuId更新数据库的spu数据
        spuMapper.updateByPrimaryKeySelective(spu);
    }

    /***
     * @title deleteBySpuId
     * @description 物理删除商品
     * @param spuId spuId
     * @return void
     * @author ayuan
     * @updateTime 2020/11/13 20:11
     */
    @Override
    public void delete(Long spuId) {
        //根据spuId查询spu对象数据
        Spu spu = spuMapper.selectByPrimaryKey(spuId);
        //判断参数是否为空
        if (spu == null) {
            throw new RuntimeException("未查询到商品");
        }
        //判断是否为逻辑删除的商品，必须先逻辑删除商品后才能物理删除
        if (!spu.getIsDelete().equalsIgnoreCase("1")) {
            throw new RuntimeException("此商品不能删除");
        }
        //调用方法删除spu数据
        spuMapper.deleteByPrimaryKey(spuId);
        //此处还应该关联删除sku数据
    }
}
