package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/***
 * @ClassName BrandServiceImpl
 * @Description 品牌业务处理
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/09 21:31:00
 */
@Service    //交给spring容器管理
public class BrandServiceImpl implements BrandService {
    //从spring容器ioc注入BrandMapper对象
    @Autowired
    private BrandMapper brandMapper;

    /***
     * @title selectAll
     * @description 查询所有品牌
     * @param
     * @return java.util.List<com.changgou.goods.pojo.Brand>
     * @author ayuan
     * @updateTime 2020/11/9 21:33
     */
    @Override
    public List<Brand> selectAll() {
        //调用brandMapper的selectAll方法获取所有品牌信息并返回结果
        return brandMapper.selectAll();
    }

    /***
     * @title findById
     * @description 根据品牌id查询品牌信息
     * @param id 商品id
     * @return com.changgou.goods.pojo.Brand
     * @author ayuan
     * @updateTime 2020/11/10 8:44
     */
    @Override
    public Brand findById(Integer id){
        //调用dao的selectByPrimaryKey方法根据品牌id查询品牌信息
        return  brandMapper.selectByPrimaryKey(id);
    }

    /***
     * @title add
     * @description 新增品牌
     * @param brand 品牌数据对象
     * @return void
     * @author ayuan
     * @updateTime 2020/11/10 9:00
     */
    @Override
    public void add(Brand brand){
        //调用brandMapper的insertSelective方法新增品牌
        brandMapper.insertSelective(brand);
    }

    /***
     * @title update
     * @description 根据品牌id修改品牌信息
     * @param brand 品牌数据对象
     * @return void
     * @author ayuan
     * @updateTime 2020/11/10 9:12
     */
    @Override
    public void update(Brand brand) {
        //调用brandMapper的updateByPrimaryKeySelective方法根据品牌id修改品牌信息
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /***
     * @title delete
     * @description 根据品牌id删除品牌信息
     * @param id 品牌id
     * @return void
     * @author ayuan
     * @updateTime 2020/11/10 9:20
     */
    @Override
    public void delete(Integer id) {
        //调用brandMapper的deleteByPrimaryKey方法根据品牌id删除品牌信息
        brandMapper.deleteByPrimaryKey(id);
    }

    /***
     * @title findList
     * @description 根据条件搜索品牌
     * @param brand 包含搜索条件的品牌数据对象
     * @return java.util.List<com.changgou.goods.pojo.Brand>
     * @author ayuan
     * @updateTime 2020/11/10 9:59
     */
    @Override
    public List<Brand> findList(Brand brand) {
        //调用方法传入搜索条件的品牌数据对象brand判断各个参数是否为空，不为空封装好搜索条件对象返回
        Example example = createExample(brand);
        //调用brandMapper的selectByExample传入搜索条件对象example进行条件搜索品牌数据
        return brandMapper.selectByExample(example);
    }

    /***
     * @title findPage
     * @description 分页查询
     * @param page 当前页
	 * @param size 每页显示多少条
     * @return com.github.pagehelper.PageInfo<com.changgou.goods.pojo.Brand>
     * @author ayuan
     * @updateTime 2020/11/10 10:41
     */
    @Override
    public PageInfo<Brand> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Brand>(brandMapper.selectAll());
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
    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //调用方法传入搜索条件的品牌数据对象brand判断各个参数是否为空，不为空封装好搜索条件对象返回
        Example example = createExample(brand);
        //根据搜索条件分页查询
        return new PageInfo<Brand>(brandMapper.selectByExample(example));
    }

    /***
     * @title createExample
     * @description 构造搜索条件，判断brand对象的各个参数是否为空，不为空则封装到搜索条件对象中，返回搜索条件对象
     * @param brand 包含搜索条件的品牌数据对象
     * @return tk.mybatis.mapper.entity.Example
     * @author ayuan
     * @updateTime 2020/11/10 10:03
     */
    private Example createExample(Brand brand) {
        Example example=new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand!=null){
            // 判断品牌名称是否为空，不为空则添加到搜索条件对象criteria中
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            // 判断品牌图片地址是否为空，不为空则添加到搜索条件对象criteria中
            if(!StringUtils.isEmpty(brand.getImage())){
                criteria.andLike("image","%"+brand.getImage()+"%");
            }
            // 判断品牌的首字母是否为空，不为空则添加到搜索条件对象criteria中
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andLike("letter","%"+brand.getLetter()+"%");
            }
            // 判断品牌id是否为空，不为空则添加到搜索条件对象criteria中
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("id",brand.getId());
            }
            // 判断排序条件是否为空，不为空则添加到搜索条件对象criteria中
            if(!StringUtils.isEmpty(brand.getSeq())){
                criteria.andEqualTo("seq",brand.getSeq());
            }
        }
        //返回封装好的搜索条件对象
        return example;
    }
}
