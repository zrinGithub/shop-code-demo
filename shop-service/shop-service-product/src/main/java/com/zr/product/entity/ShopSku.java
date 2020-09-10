package com.zr.product.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * SKU
 * </p>
 *
 * @author zhangr
 * @since 2020-09-02
 */
@TableName("shop_sku")
@Data
public class ShopSku extends Model<ShopSku> {

	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId(type = IdType.UUID)
	@TableField(value="PK_ID")
	private Long pkId;

	/**
	 * SKU ID
	 */
	@TableField(value="SKU_ID")
	private String skuId;

	/**
	 * 关联SPU ID
	 */
	@TableField(value="SPU_ID")
	private String spuId;

	/**
	 * 价格,单位：分
	 */
	private Integer price;

	/**
	 * 库存数量
	 */
	private Integer quantity;

	/**
	 * 图片地址
	 */
	@TableField(value="SKU_PIC_URL")
	private String skuPicUrl;

	/**
	 * 上下架状态，0新建，1已下架，2已上架
	 */
	private Integer status;

	/**
	 * 创建者
	 */
	@TableField(value="CREATE_BY")
	private String createBy;

	/**
	 * 创建日期（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="CREATE_TIME")
	private Date createTime;

	/**
	 * 上架时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="LIST_TIME")
	private Date listTime;

	/**
	 * 下架时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="DELIST_TIME")
	private Date delistTime;

	/**
	 * 修改日期（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="MODIFY_TIME")
	private Date modifyTime;

	/**
	 * sku最后修改人
	 */
	@TableField(value="MODIFY_BY")
	private String modifyBy;

	/**
	 * 逻辑删除标记（0：正常，1：已删除）
	 */
	@TableField(value="DELETED_FLAG")
	private Integer deletedFlag;
}
