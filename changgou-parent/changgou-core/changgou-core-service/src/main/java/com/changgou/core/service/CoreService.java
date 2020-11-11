package com.changgou.core.service;

/***
 * @ClassName CoreService
 * @Description 创建CoreService接口继承CRUDPService接口
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/11 08:59:00
 */
public interface CoreService<T> extends
        InsertService<T>,
        UpdateService<T>,
        DeleteService<T>,
        SelectService<T>,
        PagingService<T> {
}
