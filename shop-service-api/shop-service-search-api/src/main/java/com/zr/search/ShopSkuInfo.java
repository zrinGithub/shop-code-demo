package com.zr.search;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@Document(indexName = "shopskuinfo")
public class ShopSkuInfo implements Serializable {
    private static final long serialVersionUID = 385915343309977250L;
    /**
     * SKU ID
     */
    @Id
    @Field(index = true, store = true, type = FieldType.Keyword)
    private String skuId;
    /**
     * 价格,单位：分
     */
    @Field(index = true, store = true, type = FieldType.Integer)
    private Integer price;
    /**
     * 库存数量
     */
    @Field(index = true, store = true, type = FieldType.Integer)
    private Integer quantity;
    /**
     * 图片地址
     */
    @Field(index = false, store = true, type = FieldType.Text)
    private String skuPicUrl;
    /**
     * 上下架状态，0新建，1已下架，2已上架
     */
    @Field(index = true, store = true, type = FieldType.Keyword)
    private String status;
    /**
     * 创建者
     */
    @Field(index = false, store = true, type = FieldType.Text)
    private String createBy;
    /**
     * 创建日期（格式：yyyy-MM-dd HH:mm:ss）
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
     * 修改日期（格式：yyyy-MM-dd HH:mm:ss）
     */
    private Date modifyTime;
    /**
     * sku最后修改人
     */
    @Field(index = false, store = true, type = FieldType.Text)
    private String modifyBy;
    /**
     * 逻辑删除标记（0：正常，1：已删除）
     */
    @Field(index = false, store = true, type = FieldType.Text)
    private String deletedFlag;
}
