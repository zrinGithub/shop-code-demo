package com.zr.product.exception.handler;

import com.zr.common.entity.RespVo;
import com.zr.common.exception.ShopBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * 异常处理
 *
 * @author zhangr
 * 2020/9/7 11:15
 */
@RestControllerAdvice
@Slf4j
public class ShopBaseExceptionAdvice {
    @ExceptionHandler(value = {Exception.class})
    public RespVo<String> respError(HttpServletRequest request, Exception e) {
        log.error("exception:", e);
        if (e instanceof ShopBaseException)
            return new RespVo<>(false, e.getMessage(), "业务错误");
        else
            return new RespVo<>(false, "服务内部错误，请联系管理员", "内部错误");
    }
}
