package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.SpecMapper;
import com.changgou.goods.pojo.Spec;
import com.changgou.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/***
 * @ClassName SpecServiceImpl
 * @Description 规格业务层处理
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:34:00
 */
@Service    //交给Spring容器管理
public class SpecServiceImpl extends CoreServiceImpl<Spec> implements SpecService {
    //定义SpecMapper对象
    private SpecMapper specMapper;

    @Autowired
    public SpecServiceImpl(SpecMapper specMapper) {
        super(specMapper, Spec.class);
        //给SpecMapper对象赋值
        this.specMapper = specMapper;
    }
}
