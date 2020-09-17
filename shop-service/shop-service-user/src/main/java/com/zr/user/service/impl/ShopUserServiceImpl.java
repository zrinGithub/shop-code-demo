package com.zr.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.common.util.JWTUtil;
import com.zr.user.entity.ShopUser;
import com.zr.user.mapper.ShopUserMapper;
import com.zr.user.model.LoginRequest;
import com.zr.user.service.IShopUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
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
        if (user != null && user.getPassword().equals(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()))) {
            //创建用户令牌信息
            Map<String, Object> userJwt = new HashMap<>();
            userJwt.put("userName", user.getUserName());
            userJwt.put("role", "admin");
            String jwt = JWTUtil.createJWT(UUID.randomUUID().toString().replace("-", ""),
                    "用户信息", null, userJwt);
            //保存令牌信息到cookie

            //把令牌作为参数返回给用户

            return true;
        } else
            return false;
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
