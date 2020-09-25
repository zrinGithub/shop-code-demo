package com.zr.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单明细表
 * </p>
 *
 * @author zhangr
 * @since 2020-09-24
 */
@TableName("shop_order_item")
@Data
public class ShopOrderItem extends Model<ShopOrderItem> {

    private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId(type = IdType.UUID)
	@TableField(value="PK_ID")
	private Long pkId;

	/**
	 * 订单明细 ID
	 */
	@TableField(value="ORDER_ITEM_ID")
	private String orderItemId;

	/**
	 * 订单 ID
	 */
	@TableField(value="ORDER_ID")
	private String orderId;

	/**
	 * 子订单 ID
	 */
	@TableField(value="SUB_ORDER_ID")
	private String subOrderId;

	/**
	 * SKU ID
	 */
	@TableField(value="SKU_ID")
	private String skuId;

	/**
	 * 购买数量
	 */
	private Integer num;

	/**
	 * 单价,单位：分
	 */
	private Integer price;

	/**
	 * 总金额,单位：分
	 */
	@TableField(value="PRODUCT_FEE")
	private Integer productFee;

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
	 * 最后修改人
	 */
	@TableField(value="MODIFY_BY")
	private String modifyBy;

	/**
	 * 修改日期（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="MODIFY_TIME")
	private Date modifyTime;

	/**
	 * 逻辑删除标记（0：正常，1：已删除）
	 */
	@TableField(value="DELETED_FLAG")
	private Integer deletedFlag;
}
