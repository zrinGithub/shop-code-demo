package com.zr.product.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * SKU
 * </p>
 *
 * @author zhangr
 * @since 2020-09-02
 */
@Data
@ApiModel(description = "信息类")
public class ShopSkuVo implements Serializable {
    private static final long serialVersionUID = 385915343309977250L;
    /**
     * 自增主键
     */
    @ApiModelProperty("自增主键")
    private Long pkId;
    /**
     * SKU ID
     */
    @ApiModelProperty("SKU ID")
    private String skuId;
    /**
     * 关联SPU ID
     */
    @ApiModelProperty("关联SPU ID")
    private String spuId;
    /**
     * 价格,单位：分
     */
    @ApiModelProperty("价格,单位：分")
    private Integer price;
    /**
     * 库存数量
     */
    @ApiModelProperty("库存数量")
    private Integer quantity;
    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private String skuPicUrl;
    /**
     * 上下架状态，0新建，1已下架，2已上架
     */
    @ApiModelProperty("上下架状态，0新建，1已下架，2已上架")
    private Object status;
    /**
     * 创建者
     */
    @ApiModelProperty("创建者")
    private String createBy;
    /**
     * 创建日期（格式：yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty("创建日期（格式：yyyy-MM-dd HH:mm:ss）")
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
     * 修改日期（格式：yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty("修改日期（格式：yyyy-MM-dd HH:mm:ss）")
    private Date modifyTime;
    /**
     * sku最后修改人
     */
    @ApiModelProperty("sku最后修改人")
    private String modifyBy;
    /**
     * 逻辑删除标记（0：正常，1：已删除）
     */
    @ApiModelProperty("逻辑删除标记（0：正常，1：已删除）")
    private Object deletedFlag;
}
