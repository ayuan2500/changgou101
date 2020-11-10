package com.changgou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/***
 * @ClassName GoodsApplication
 * @Description 商品微服务启动类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/09 17:52:00
 */
@SpringBootApplication
@EnableEurekaClient     //开启Eureka客户端，交给eureka服务端进行管理
@MapperScan(basePackages = {"com.changgou.goods.dao"})  //用于扫描Mapper接口
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class);
    }
}