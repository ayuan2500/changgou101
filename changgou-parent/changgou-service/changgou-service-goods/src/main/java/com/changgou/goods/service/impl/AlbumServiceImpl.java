package com.changgou.goods.service.impl;

import com.changgou.goods.dao.AlbumMapper;
import com.changgou.goods.service.AlbumService;
import com.changgou.core.service.impl.CoreServiceImpl;
import com.changgou.goods.pojo.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @ClassName AlbumServiceImpl
 * @Description 描述
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 14:51:00
 */

@Service    //交给spring容器管理
public class AlbumServiceImpl extends CoreServiceImpl<Album> implements AlbumService {

    private AlbumMapper albumMapper;

    @Autowired    //从spring容器获取ioc注入albumMapper对象
    public AlbumServiceImpl(AlbumMapper albumMapper) {
        super(albumMapper, Album.class);
        this.albumMapper=albumMapper;
    }
}