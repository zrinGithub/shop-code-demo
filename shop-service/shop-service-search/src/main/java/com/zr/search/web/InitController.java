package com.zr.search.web;

import com.zr.product.client.ShopSkuClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/10 16:57
 */
@Api("测试")
@RestController
@RequestMapping("test")
public class InitController {
    @Resource
    private ShopSkuClient skuClient;

    @ApiOperation("测试展示sku")
    @GetMapping("listSku")
    public Object listSku() {
        return skuClient.list();
    }
}
