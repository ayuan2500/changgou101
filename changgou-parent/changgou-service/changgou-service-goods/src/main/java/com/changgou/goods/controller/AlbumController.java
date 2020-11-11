package com.changgou.goods.controller;

import com.changgou.goods.service.AlbumService;
import com.changgou.core.controller.AbstractCoreController;
import com.changgou.goods.pojo.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @ClassName AlbumController
 * @Description 相册控制层
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 14:55:00
 */
@RestController //交给spring容器管理
@RequestMapping("/album")   //设置请求路径
public class AlbumController extends AbstractCoreController<Album> {

    //从spring容器获取ioc注入brandService对象
    @Autowired
    public AlbumController(AlbumService albumService) {
        super(albumService, Album.class);
    }
}
