package com.changgou.goods.controller;

import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Spec;
import com.changgou.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @ClassName SpecController
 * @Description 规格控制层
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 16:37:00
 */
@RestController
@RequestMapping("/spec")
public class SpecController extends AbstractCoreController<Spec> {
    @Autowired
    public SpecController(SpecService specService) {
        super(specService, Spec.class);
    }
}
