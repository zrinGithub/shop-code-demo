package com.zr.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 *
 * @author zhangr
 * 2020/8/20 17:00
 */
@Data
@AllArgsConstructor
public class RespVo<T> {
    //返回结果 true成功 false失败
    private boolean res;
    //返回数据
    private T content;
    //返回提示信息
    private String msg;
}
