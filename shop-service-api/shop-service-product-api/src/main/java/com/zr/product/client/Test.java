package com.zr.product.client;

import java.time.LocalDate;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/10 17:30
 */
public class Test {
    public static void main(String[] args) {
        long seed = +LocalDate.now().getDayOfYear();
        System.out.println(seed);
    }
}
