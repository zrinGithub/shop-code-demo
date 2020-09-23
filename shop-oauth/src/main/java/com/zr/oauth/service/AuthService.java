package com.zr.oauth.service;

import com.zr.oauth.util.AuthToken;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/23 14:54
 */
public interface AuthService {
    AuthToken login(String userName, String password, String clientId, String clientSecret);
}
