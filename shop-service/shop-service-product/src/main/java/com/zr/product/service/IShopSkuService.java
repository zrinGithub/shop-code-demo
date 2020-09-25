package com.zr.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zr.product.entity.ShopSku;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhangr
 * @since 2020-09-02
 */
public interface IShopSkuService extends IService<ShopSku> {
    ShopSku getById(String skuId);

    List<ShopSku> getByIds(List<String> skuIds);
}
