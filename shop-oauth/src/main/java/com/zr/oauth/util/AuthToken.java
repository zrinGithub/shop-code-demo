package com.zr.oauth.util;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/23 14:55
 */
@Data
public class AuthToken implements Serializable {
    private static final long serialVersionUID = -3707828568426944047L;

    //令牌
    private String accessToken;
    //刷新令牌
    private String refreshToken;
    //jwt短令牌
    private String jti;
}
