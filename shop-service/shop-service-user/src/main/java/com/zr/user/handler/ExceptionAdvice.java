package com.zr.user.handler;

import com.zr.common.entity.RespVo;
import com.zr.common.exception.ShopBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/16 15:40
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler(value = {Exception.class})
    public RespVo<String> respError(HttpServletRequest request, Exception e) {
//        log.error("exception:", e);
        if (e instanceof ShopBaseException)
            return new RespVo<>(false, e.getMessage(), "业务错误");
        else if (e instanceof MethodArgumentNotValidException)
            return new RespVo<>(false, ((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage(), "参数校验未通过");
        else
            return new RespVo<>(false, "服务内部错误，请联系管理员", "内部错误");
    }
}
