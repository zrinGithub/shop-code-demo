package com.zr.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.product.entity.ShopCategory;
import com.zr.product.mapper.ShopCategoryMapper;
import com.zr.product.service.IShopCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 类别表  服务实现类
 * </p>
 *
 * @author zhangr
 * @since 2020-09-02
 */
@Service
public class ShopCategoryServiceImpl extends ServiceImpl<ShopCategoryMapper, ShopCategory> implements IShopCategoryService {
	
}
