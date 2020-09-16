package com.zr.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录表(ShopUser)实体类
 *
 * @author makejava
 * @since 2020-09-15 15:37:45
 */
@Data
@TableName("shop_user")
public class ShopUser extends Model<ShopUser> implements Serializable {
    private static final long serialVersionUID = 205972255407257072L;
    /**
     * 自增主键
     */
    @TableId(value = "PK_ID")
    private Long pkId;
    /**
     * USER_ID
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    private Date createTime;
    /**
     * 上架时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    private Date listTime;
    /**
     * 下架时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    private Date delistTime;
    /**
     * 修改时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    private Date modifyTime;
    /**
     * 修改者
     */
    private String modifyBy;
    /**
     * 逻辑删除标记（0：正常，1：已删除）
     */
    @TableLogic(value = "0", delval = "1")
    private Object deletedFlag;


}