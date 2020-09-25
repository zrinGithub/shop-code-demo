package com.zr.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.order.entity.ShopOrder;
import com.zr.order.mapper.ShopOrderMapper;
import com.zr.order.model.CommitOrderItemRequest;
import com.zr.order.model.CommitOrderRequest;
import com.zr.order.service.IShopOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品订单表  服务实现类
 * </p>
 *
 * @author zhangr
 * @since 2020-09-24
 */
@Service
public class ShopOrderServiceImpl extends ServiceImpl<ShopOrderMapper, ShopOrder> implements IShopOrderService {

    @Override
    public void commitOrder(CommitOrderRequest request) {
        List<CommitOrderItemRequest> itemList = request.getItemList();

    }
}
