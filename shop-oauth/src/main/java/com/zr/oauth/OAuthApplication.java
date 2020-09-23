package com.zr.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/22 14:56
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.zr.*.client"})
@RestController
public class OAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class, args);
    }
}
