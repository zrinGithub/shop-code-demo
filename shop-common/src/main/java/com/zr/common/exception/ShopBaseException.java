package com.zr.common.exception;

/**
 * Description:
 * 自定义异常类
 *
 * @author zhangr
 * 2020/9/7 11:20
 */
public class ShopBaseException extends Exception {
    public ShopBaseException(String errMsg) {
        super(errMsg);
    }

    public ShopBaseException(String errMsg, Throwable t) {
        super(errMsg, t);
    }
}
