package com.zr.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/15 15:58
 */
@Data
@ApiModel("根据用户名称请求用户信息信息")
public class QueryUserRequest {
    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户ID")
    private String userId;
}
