package com.zr.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/8 11:00
 */
@SpringBootApplication
@EnableSwagger2
public class HttpApplication {
    public static void main(String[] args) {
        SpringApplication.run(HttpApplication.class, args);
    }
}
