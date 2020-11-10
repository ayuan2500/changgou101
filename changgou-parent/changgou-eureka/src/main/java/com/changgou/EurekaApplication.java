package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/***
 * @ClassName EurekaApplication
 * @Description 启动类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/09 16:59:00
 */
@SpringBootApplication
@EnableEurekaServer     //启动Eureka的服务端
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class);
    }
}