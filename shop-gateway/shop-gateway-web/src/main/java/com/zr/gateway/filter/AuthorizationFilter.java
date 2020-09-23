package com.zr.gateway.filter;

import com.zr.common.util.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Description:
 * 实现用户鉴权
 *
 * @author zhangr
 * 2020/9/18 8:58
 */
@Component
public class AuthorizationFilter implements GlobalFilter, Ordered {
    //定义header的键
    private static final String AUTHORIZE_TOKEN = "Authorization";

    /**
     * 全局拦截
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //如果是登录，直接放行
        if ("/user-service/shopuser/login".equals(request.getURI().getPath())) {
            return chain.filter(exchange);
        }

        //获取用户令牌信息
        //从header里面获取
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);
        //如果是在参数中
        if (StringUtils.isBlank(token)) token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        //如果是在Cookie中
        if (StringUtils.isBlank(token)) {
            HttpCookie httpCookie = request.getCookies().getFirst(AUTHORIZE_TOKEN);
            if (httpCookie != null) {
                token = httpCookie.getValue();
            }
        }

        //如果没有令牌则进行拦截
        if (StringUtils.isBlank(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //响应空数据
            return response.setComplete();
        }

        //检验令牌是否有效
        try {
            JWTUtil.parseJWT(token);
        } catch (Exception e) {
            //可能会出现过期等信息，也就是解析无效
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //响应空数据
            return response.setComplete();
        }
        //对有效的令牌放行，并且把令牌放在头文件里面，这样可以传递给后面的服务
        request.mutate().header(AUTHORIZE_TOKEN, token);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
