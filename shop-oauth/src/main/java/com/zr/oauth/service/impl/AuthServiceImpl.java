package com.zr.oauth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zr.common.exception.ShopBaseException;
import com.zr.oauth.service.AuthService;
import com.zr.oauth.util.AuthToken;
import io.netty.handler.codec.base64.Base64Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/23 14:58
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //过期时间，单位秒
    @Value("${auth.ttl}")
    private long ttl;

    @Override
    public AuthToken login(String userName, String password, String clientId, String clientSecret) {
        //申请令牌
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-auth");
        URI uri = serviceInstance.getUri();
        String url = uri + "/oauth/token";

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("grant_type", "password");
        param.add("username", userName);
        param.add("password", password);


        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.AUTHORIZATION, getHttpBasic(clientId, clientSecret));
        HttpEntity<String> request = new HttpEntity<>(JSONObject.toJSONString(param), header);

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400 && response.getRawStatusCode() != 401) {
                    super.handleError(response);
                }
            }
        });

        JSONObject response = restTemplate.exchange(url, HttpMethod.POST, request, JSONObject.class).getBody();
        if (response == null || response.getString("access_token") == null)
            throw new ShopBaseException("申请令牌失败");

        //封装请求结果的数据
        AuthToken authToken = new AuthToken();
        authToken.setAccessToken(response.getString("access_token"));
        authToken.setRefreshToken(response.getString("refresh_token"));
        authToken.setJti(response.getString("jti"));

        //将jti作为redis中的key，jwt作为val存储。
        stringRedisTemplate.boundValueOps(authToken.getJti()).set(authToken.getAccessToken(), ttl, TimeUnit.SECONDS);
        return authToken;
    }

    private String getHttpBasic(String clientId, String clientSecret) {
        String value = clientId + ":" + clientSecret;
        byte[] encode = Base64Utils.encode(value.getBytes());
        return "Basic " + new String(encode);
    }
}
