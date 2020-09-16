package com.zr.user.web;

import com.zr.common.entity.RespVo;
import com.zr.user.model.LoginRequest;
import com.zr.user.service.IShopUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/15 15:46
 */
@RestController
@RequestMapping("/shopuser")
@Api("用户信息")
public class ShopUserController {
    @Resource
    private IShopUserService userService;

    @PostMapping("login")
    @ApiOperation("用户登录")
    private RespVo<String> login(@Valid @RequestBody LoginRequest request) {
        if (userService.login(request))
            return new RespVo<>("登录成功");
        else
            return new RespVo<>(false, "用户名或密码错误", "操作失败");
    }

    @PostMapping("add")
    @ApiOperation("添加用户")
    private RespVo<String> add(@Valid @RequestBody LoginRequest request) {
        if (userService.add(request))
            return new RespVo<>("添加成功");
        else
            return new RespVo<>(false, "操作失败", "操作失败");
    }
}
