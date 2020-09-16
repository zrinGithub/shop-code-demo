package com.zr.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/15 15:39
 */
@Data
@ApiModel(description = "用户登录信息")
public class ShopUserVo  implements Serializable {
    private static final long serialVersionUID = -42892175109644621L;
    /**
     * 自增主键
     */
    @ApiModelProperty("自增主键")
    private Long pkId;
    /**
     * USER_ID
     */
    @ApiModelProperty("USER_ID")
    private String userId;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 创建时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty("创建时间（格式：yyyy-MM-dd HH:mm:ss）")
    private Date createTime;
    /**
     * 上架时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty("上架时间（格式：yyyy-MM-dd HH:mm:ss）")
    private Date listTime;
    /**
     * 下架时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty("下架时间（格式：yyyy-MM-dd HH:mm:ss）")
    private Date delistTime;
    /**
     * 修改时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty("修改时间（格式：yyyy-MM-dd HH:mm:ss）")
    private Date modifyTime;
    /**
     * 修改者
     */
    @ApiModelProperty("修改者")
    private String modifyBy;
    /**
     * 逻辑删除标记（0：正常，1：已删除）
     */
    @ApiModelProperty("逻辑删除标记（0：正常，1：已删除）")
    private Object deletedFlag;
}
