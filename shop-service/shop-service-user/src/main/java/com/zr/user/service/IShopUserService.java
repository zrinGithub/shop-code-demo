package com.zr.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zr.common.entity.RespVo;
import com.zr.user.entity.ShopUser;
import com.zr.user.model.LoginRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/15 15:44
 */
public interface IShopUserService extends IService<ShopUser> {
    RespVo<String> login(LoginRequest request, HttpServletResponse response);

    boolean add(LoginRequest request);
}
