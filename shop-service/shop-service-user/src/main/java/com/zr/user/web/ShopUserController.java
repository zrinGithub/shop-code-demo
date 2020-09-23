package com.zr.user.web;

import com.zr.common.entity.RespVo;
import com.zr.user.model.LoginRequest;
import com.zr.user.model.QueryUserRequest;
import com.zr.user.model.ShopUserVo;
import com.zr.user.service.IShopUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
    private RespVo<String> login(@Valid @RequestBody LoginRequest request, HttpServletResponse response) {
        return userService.login(request, response);
    }

    @PostMapping("add")
    @ApiOperation("添加用户")
    private RespVo<String> add(@Valid @RequestBody LoginRequest request) {
        if (userService.add(request))
            return new RespVo<>("添加成功");
        else
            return new RespVo<>(false, "操作失败", "操作失败");
    }

    @PostMapping("query")
    @ApiOperation("精确查询用户信息")
    private RespVo<ShopUserVo> queryUserInfo(@RequestBody QueryUserRequest request) {
        ShopUserVo shopUserVo = userService.queryUserInfo(request);
        if (shopUserVo == null) return new RespVo<>(false, null, "查询不到用户");
        return new RespVo<>(shopUserVo);
    }
}
