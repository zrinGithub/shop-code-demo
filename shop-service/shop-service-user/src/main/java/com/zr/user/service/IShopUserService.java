package com.zr.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zr.user.entity.ShopUser;
import com.zr.user.model.LoginRequest;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/15 15:44
 */
public interface IShopUserService extends IService<ShopUser> {
    boolean login(LoginRequest request);
    boolean add(LoginRequest request);
}
