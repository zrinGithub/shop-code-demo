package com.zr.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.common.entity.RespVo;
import com.zr.common.util.JWTUtil;
import com.zr.common.util.SpringBeanUtils;
import com.zr.user.entity.ShopUser;
import com.zr.user.mapper.ShopUserMapper;
import com.zr.user.model.LoginRequest;
import com.zr.user.model.QueryUserRequest;
import com.zr.user.model.ShopUserVo;
import com.zr.user.service.IShopUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public RespVo<String> login(LoginRequest request, HttpServletResponse response) {
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
            Cookie cookie = new Cookie("Authorization", jwt);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);

            //也可以把令牌作为参数返回给用户
            return new RespVo<>(jwt);
        } else
            return new RespVo<>(false, "用户名或密码错误", "操作失败");
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

    @Override
    public ShopUserVo queryUserInfo(QueryUserRequest request) {
        QueryWrapper<ShopUser> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(request.getUserName()))
            wrapper.eq("USER_NAME", request.getUserName());
        if (StringUtils.isNotBlank(request.getUserName()))
            wrapper.eq("USER_ID", request.getUserId());
        return SpringBeanUtils.copyProperties(baseMapper.selectOne(wrapper), ShopUserVo.class);
    }
}
