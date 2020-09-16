package com.zr.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.user.entity.ShopUser;
import com.zr.user.mapper.ShopUserMapper;
import com.zr.user.model.LoginRequest;
import com.zr.user.service.IShopUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/15 15:45
 */
@Service
public class ShopUserServiceImpl extends ServiceImpl<ShopUserMapper, ShopUser> implements IShopUserService {
    @Override
    public boolean login(LoginRequest request) {
        //查询用户数据库信息
        QueryWrapper<ShopUser> wrapper = new QueryWrapper<>();
        wrapper.eq("USER_NAME", request.getUserName());
        ShopUser user = baseMapper.selectOne(wrapper);

        //验证信息
        return user != null && user.getPassword().equals(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
    }

    @Override
    public boolean add(LoginRequest request) {
        //查询用户数据库信息
        ShopUser shopUser = new ShopUser();
        shopUser.setUserName(request.getUserName());
        shopUser.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
        shopUser.setUserId(UUID.randomUUID().toString().replace("-", ""));
        return baseMapper.insert(shopUser) == 1;
    }
}
