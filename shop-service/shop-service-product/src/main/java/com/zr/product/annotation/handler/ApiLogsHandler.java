package com.zr.product.annotation.handler;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/7 11:34
 */
@Aspect
@Component
@Slf4j
public class ApiLogsHandler {
    @Pointcut("@annotation(com.zr.product.annotation.ApiLogs)")
    public void apiLog() {
    }

    @Around(value = "apiLog()")
    public void printApiLogs(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //类名
        String className = joinPoint.getTarget().getClass().getName();
        //方法
        String methodName = joinPoint.getSignature().getName();
        //参数
        String argsStr = JSONObject.toJSONString(joinPoint.getArgs());
        long startTime = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        log.info("enter class:{}", className);
        log.info("      method:{}", methodName);
        log.info("      useTime:{}", endTime - startTime);
        log.info("      response:{}", JSONObject.toJSONString(res));
    }
}
