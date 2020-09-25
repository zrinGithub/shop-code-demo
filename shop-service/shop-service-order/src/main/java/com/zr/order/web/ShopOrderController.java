package com.zr.order.web;

import com.zr.common.entity.RespVo;
import com.zr.order.model.CommitOrderRequest;
import com.zr.order.service.IShopOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 商品订单表  前端控制器
 * </p>
 *
 * @author zhangr
 * @since 2020-09-24
 */
@Controller
@RequestMapping("/shoporder")
@Api("订单")
public class ShopOrderController {
    @Resource
    private IShopOrderService orderService;

    @PostMapping("/commitOrder")
    @ApiOperation("提交订单")
    public RespVo<String> commitOrder(@Valid @RequestBody CommitOrderRequest request) {
        orderService.commitOrder(request);
        return new RespVo<>("操作完成");
    }
}
