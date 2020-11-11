package com.changgou.goods.service.impl;

import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.dao.ParaMapper;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @ClassName ParaServiceImpl
 * @Description 参数业务层处理
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:48:00
 */
@Service    //交给Spring容器管理
public class ParaServiceImpl extends CoreServiceImpl<Para> implements ParaService {
    //定义ParaMapper对象
    private ParaMapper paraMapper;

    @Autowired
    public ParaServiceImpl(ParaMapper paraMapper) {
        super(paraMapper,Para.class);
        //给paraMapper对象赋值
        this.paraMapper = paraMapper;
    }
}
