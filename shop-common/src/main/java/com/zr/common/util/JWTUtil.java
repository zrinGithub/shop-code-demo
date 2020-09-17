package com.zr.common.util;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/16 11:00
 */
public class JWTUtil {
    //有效期
    public static final Long JWT_TTL = 60L * 60 * 1000; //一个小时
    //设置秘钥明文
    public static final String JWT_KEY = "test";

    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return
     */
    private static Key generalKey() {
        return new SecretKeySpec(JWT_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }


    /**
     * 生成JWT令牌
     *
     * @param id      id
     * @param subject 主题
     * @param ttl     有效时间，单位 ms
     * @param claims  自定义参数
     * @return 返回JWT令牌
     */
    public static String createJWT(String id, String subject, Long ttl, Map<String, Object> claims) {
        if (ttl == null) ttl = JWT_TTL;
        long exp = System.currentTimeMillis() + ttl;
        Date expDate = new Date(exp);
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, generalKey())
                .setExpiration(expDate)
                .addClaims(claims);
        return builder.compact();
    }

    /**
     * 解析令牌
     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "jason");
        String jwt = createJWT("111", "AA", 22000L, map);
        System.out.println(JSONObject.toJSONString(parseJWT(jwt)));
    }
}
