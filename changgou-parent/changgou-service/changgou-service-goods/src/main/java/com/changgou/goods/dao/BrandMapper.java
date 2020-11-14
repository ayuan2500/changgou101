package com.changgou.goods.dao;
import com.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:admin
 * @Description:Brand的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface BrandMapper extends Mapper<Brand> {
    //根据分类id查询品牌列表集合
    @Select("select b.* from  tb_category_brand cb, tb_brand b where cb.category_id = #{categoryId} and cb.brand_id = b.id")
    List<Brand> findByCategoryId(Integer categoryId);
}
