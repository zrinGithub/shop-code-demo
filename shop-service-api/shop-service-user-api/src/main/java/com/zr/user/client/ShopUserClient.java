package com.zr.user.client;

import com.zr.common.entity.RespVo;
import com.zr.user.model.LoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/2 9:45
 */
@FeignClient(name = "user-service")
@Api("用户信息")
public interface ShopUserClient {
    @PostMapping("/shopuser/login")
    @ApiOperation("用户登录")
    RespVo<String> login(@RequestBody LoginRequest request, HttpServletResponse response);

    @PostMapping("/shopuser/add")
    @ApiOperation("添加用户")
    RespVo<String> add(@RequestBody LoginRequest request);
}
