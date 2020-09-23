package com.zr.oauth.util;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/23 11:12
 */
@Data
public class UserJwt extends User {
    //用户id
    private String id;
    //用户名称
    private String name;

    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
