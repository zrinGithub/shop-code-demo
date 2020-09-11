package com.zr.product.web;

import com.zr.common.entity.RespVo;
import com.zr.common.exception.ShopBaseException;
import com.zr.common.util.SpringBeanUtils;
import com.zr.product.annotation.ApiLogs;
import com.zr.product.service.IShopSkuService;
import com.zr.product.model.ShopSkuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * SKU表  前端控制器
 * </p>
 *
 * @author zhangr
 * @since 2020-09-02
 */
@RestController
@RequestMapping("/shopsku")
@Api("sku")
public class ShopSkuController {
    @Resource
    private IShopSkuService shopSkuService;

    @GetMapping("list")
    @ApiOperation("查询")
    @ApiLogs
    public RespVo<List<ShopSkuVo>> list() {
        return new RespVo<>(SpringBeanUtils.copy(shopSkuService.list(),ShopSkuVo.class));
    }

    @GetMapping("exception")
    @ApiOperation("异常测试")
    @ApiLogs
    public void ex() throws Exception {
        throw new Exception();
    }

    @GetMapping("customException")
    @ApiOperation("异常测试2")
    @ApiLogs
    public void ex2() throws Exception {
        throw new ShopBaseException("AAA");
    }
}
