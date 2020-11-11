package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Para;
import com.changgou.goods.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @ClassName ParaController
 * @Description 参数控制层
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:51:00
 */
@RestController
@RequestMapping("/para")
public class ParaController extends AbstractCoreController<Para> {
    @Autowired
    public ParaController(ParaService paraService) {
        super(paraService, Para.class);
    }
}
