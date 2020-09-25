package com.zr.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zr.order.entity.ShopOrder;
import com.zr.order.model.CommitOrderRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhangr
 * @since 2020-09-24
 */
public interface IShopOrderService extends IService<ShopOrder> {
    /**
     * 提交订单
     */
    void commitOrder(CommitOrderRequest request);

}
