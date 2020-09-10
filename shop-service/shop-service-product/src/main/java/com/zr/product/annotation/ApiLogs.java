package com.zr.product.annotation;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/7 11:25
 */
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiLogs {
    /**
     * 描述信息
     *
     * @return
     */
    String desc() default "";
}
