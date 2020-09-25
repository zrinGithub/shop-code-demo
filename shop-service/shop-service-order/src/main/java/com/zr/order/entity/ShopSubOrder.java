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
 * 商品子订单表
 * </p>
 *
 * @author zhangr
 * @since 2020-09-24
 */
@TableName("shop_sub_order")
@Data
public class ShopSubOrder extends Model<ShopSubOrder> {

    private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId(type = IdType.UUID)
	@TableField(value="PK_ID")
	private Long pkId;

	/**
	 * 子订单 ID
	 */
	@TableField(value="SUB_ORDER_ID")
	private String subOrderId;

	/**
	 * 订单 ID
	 */
	@TableField(value="ORDER_ID")
	private String orderId;

	/**
	 * 厂家（库房） ID
	 */
	@TableField(value="STORE_ID")
	private String storeId;

	/**
	 * 商品分摊金额,单位：分
	 */
	@TableField(value="PRODUCT_PART_FEE")
	private Integer productPartFee;

	/**
	 * 邮费分摊金额,单位：分
	 */
	@TableField(value="POST_PART_FEE")
	private Integer postPartFee;

	/**
	 * 实际收款金额,单位：分
	 */
	@TableField(value="PAY_PART_AMOUNT")
	private Integer payPartAmount;

	/**
	 * 发货时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="POST_TIME")
	private Date postTime;

	/**
	 * 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="FINISH_TIME")
	private Date finishTime;

	/**
	 * 交易关闭时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="CLOSE_TIME")
	private Date closeTime;

	/**
	 * 买家留言
	 */
	@TableField(value="BUYER_REMARK")
	private String buyerRemark;

	/**
	 * 物流名称
	 */
	@TableField(value="SHIPPING_NAME")
	private String shippingName;

	/**
	 * 物流单号
	 */
	@TableField(value="SHIPPING_CODE")
	private String shippingCode;

	/**
	 * 物流状态 0:未发货 1:已发货 2:已送达 3:异常
	 */
	@TableField(value="SHIPPING_STATUS")
	private Integer shippingStatus;

	/**
	 * 订单状态: 1：待付款 2：待发货 3：已发货 4：已签收 5：确认收货 6：售后期 7：交易完成 8：关闭
	 */
	@TableField(value="SUB_ORDER_STATUS")
	private Integer subOrderStatus;

	/**
	 * 用户ID
	 */
	@TableField(value="CST_ID")
	private String cstId;

	/**
	 * 用户名称
	 */
	@TableField(value="CST_NAME")
	private String cstName;

	/**
	 * 收货人名称
	 */
	@TableField(value="RECEIVER_NAME")
	private String receiverName;

	/**
	 * 收货人手机
	 */
	@TableField(value="RECEIVER_PHONE")
	private String receiverPhone;

	/**
	 * 收货人地址
	 */
	@TableField(value="RECEIVER_ADDR")
	private String receiverAddr;

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
