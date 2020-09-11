package com.zr.product.client;

import com.zr.common.entity.RespVo;
import com.zr.product.model.ShopSkuVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/2 9:45
 */
@FeignClient(name = "product-service")
public interface ShopSkuClient {
    @GetMapping("/shopsku/list")
    RespVo<List<ShopSkuVo>> list();
}
