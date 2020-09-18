package com.zr.product.client;

import com.zr.common.entity.RespVo;
import com.zr.product.model.ShopSkuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("sku信息")
public interface ShopSkuClient {
    @GetMapping("/shopsku/list")
    @ApiOperation("列表")
    RespVo<List<ShopSkuVo>> list();
}
