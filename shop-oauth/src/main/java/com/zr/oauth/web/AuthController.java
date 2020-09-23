package com.zr.oauth.web;

import com.zr.common.entity.RespVo;
import com.zr.oauth.service.AuthService;
import com.zr.oauth.util.AuthToken;
import com.zr.user.model.LoginRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/23 15:24
 */
@Controller
@RequestMapping("/oauth")
public class AuthController {
    @Resource
    private AuthService authService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    @Value("${auth.cookieMaxAge}")
    private String cookieMaxAge;

    @GetMapping("loginPage")
    public String loginPage(@RequestParam(value = "from", required = false, defaultValue = "") String from, Model model) {
        model.addAttribute("from", from);
        return "login";
    }

    @PostMapping("login")
    @ResponseBody
    public RespVo<String> login(@Valid @RequestBody LoginRequest account, HttpServletResponse response) {
        //申请令牌
        AuthToken authToken = authService.login(account.getUserName(), account.getPassword(), clientId, clientSecret);

        //把jti的值保存到cookie
        Cookie cookie = new Cookie("uid", authToken.getJti());
        response.addCookie(cookie);

        //返回结果
        return new RespVo<>(authToken.getJti());
    }
}
