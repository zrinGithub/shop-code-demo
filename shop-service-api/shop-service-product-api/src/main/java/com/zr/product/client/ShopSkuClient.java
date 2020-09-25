package com.zr.product.client;

import com.zr.common.entity.RespVo;
import com.zr.common.util.SpringBeanUtils;
import com.zr.product.model.ShopSkuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/2 9:45
 */
@FeignClient(name = "product-service")
@Api("sku信息")
@RequestMapping("shopsku")
public interface ShopSkuClient {
    @GetMapping("/list")
    @ApiOperation("列表")
    RespVo<List<ShopSkuVo>> list();

    @GetMapping("/get/{skuId}")
    @ApiOperation("根据id查询")
    RespVo<ShopSkuVo> get(@PathVariable("skuId") String skuId);
}
