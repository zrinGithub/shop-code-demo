package com.zr.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.product.entity.ShopSku;
import com.zr.product.mapper.ShopSkuMapper;
import com.zr.product.model.ShopSkuVo;
import com.zr.product.service.IShopSkuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 类别表  服务实现类
 * </p>
 *
 * @author zhangr
 * @since 2020-09-02
 */
@Service
public class ShopSkuServiceImpl extends ServiceImpl<ShopSkuMapper, ShopSku> implements IShopSkuService {
    @Override
    public ShopSku getById(String skuId) {
        QueryWrapper<ShopSku> wrapper = new QueryWrapper<>();
        wrapper.eq("SKU_ID", skuId);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<ShopSku> getByIds(List<String> skuIds) {
        QueryWrapper<ShopSku> wrapper = new QueryWrapper<>();
        wrapper.in("SKU_ID", skuIds);
        return baseMapper.selectList(wrapper);
    }
}
