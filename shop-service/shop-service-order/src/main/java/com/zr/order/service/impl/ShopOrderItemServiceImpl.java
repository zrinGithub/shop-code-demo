package com.zr.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.order.entity.ShopOrderItem;
import com.zr.order.mapper.ShopOrderItemMapper;
import com.zr.order.service.IShopOrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表  服务实现类
 * </p>
 *
 * @author zhangr
 * @since 2020-09-24
 */
@Service
public class ShopOrderItemServiceImpl extends ServiceImpl<ShopOrderItemMapper, ShopOrderItem> implements IShopOrderItemService {
	
}
