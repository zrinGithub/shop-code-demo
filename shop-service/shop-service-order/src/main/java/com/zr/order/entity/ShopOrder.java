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
 * 商品订单表
 * </p>
 *
 * @author zhangr
 * @since 2020-09-24
 */
@TableName("shop_order")
@Data
public class ShopOrder extends Model<ShopOrder> {

    private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId(type = IdType.UUID)
	@TableField(value="PK_ID")
	private Long pkId;

	/**
	 * 订单 ID
	 */
	@TableField(value="ORDER_ID")
	private String orderId;

	/**
	 * 商品金额,单位：分
	 */
	@TableField(value="PRODUCT_FEE")
	private Integer productFee;

	/**
	 * 邮费金额,单位：分
	 */
	@TableField(value="POST_FEE")
	private Integer postFee;

	/**
	 * 实际支付金额,单位：分
	 */
	@TableField(value="PAY_AMOUNT")
	private Integer payAmount;

	/**
	 * 支付类型 0 线上支付 1 货到付款
	 */
	@TableField(value="PAY_TYPE")
	private Integer payType;

	/**
	 * 支付状态 0 未支付 1 已支付
	 */
	@TableField(value="PAY_STATUS")
	private Integer payStatus;

	/**
	 * 订单状态 0:挂起 1:已拆分 2:已关闭 3:交易完成 4:结单
	 */
	@TableField(value="ORDER_STATUS")
	private Integer orderStatus;

	/**
	 * 支付时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	@TableField(value="PAY_TIME")
	private Date payTime;

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
