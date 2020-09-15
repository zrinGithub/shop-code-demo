package com.zr.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/14 16:15
 */
@SpringBootApplication
@EnableEurekaClient
public class ShopGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopGatewayApplication.class, args);
    }

    @Bean(name = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return (exchange) -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
