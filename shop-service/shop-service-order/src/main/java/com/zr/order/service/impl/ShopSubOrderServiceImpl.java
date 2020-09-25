package com.zr.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.order.entity.ShopSubOrder;
import com.zr.order.mapper.ShopSubOrderMapper;
import com.zr.order.service.IShopSubOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品子订单表  服务实现类
 * </p>
 *
 * @author zhangr
 * @since 2020-09-24
 */
@Service
public class ShopSubOrderServiceImpl extends ServiceImpl<ShopSubOrderMapper, ShopSubOrder> implements IShopSubOrderService {
	
}
