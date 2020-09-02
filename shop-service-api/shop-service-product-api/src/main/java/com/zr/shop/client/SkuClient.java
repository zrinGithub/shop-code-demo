package com.zr.shop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/2 9:45
 */
@FeignClient(name = "shop-service-sku")
public class SkuClient {
//    @GetMapping("/sku/{skuId}")

}
