package com.zr.canal;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 *
 * @author zhangr
 * 2020/8/31 16:49
 */
@SpringBootApplication
@EnableCanalClient
@EnableEurekaClient
public class CanalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class);
    }
}
