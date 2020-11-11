package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 * @ClassName FileApplication
 * @Description 描述
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/10 20:01:00
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})	//禁止DataSource的加载创建
@EnableEurekaClient    //开启Eureka客户端，交给Eureka服务器
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class);
    }
}
