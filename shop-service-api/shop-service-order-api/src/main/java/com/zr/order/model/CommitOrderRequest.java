package com.zr.order.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Description:
 * 这里做一个简单的请求测试，所以没有啥用户信息，只有sku信息
 * @author zhangr
 * 2020/9/24 15:46
 */
@ApiModel("提交订单-请求体")
@Data
public class CommitOrderRequest {
    @ApiModelProperty("用户ID")
    @NotEmpty(message = "用户ID 不能为空")
    private String cstId;

    @ApiModelProperty("买家留言")
    private String buyerRemark;

    @ApiModelProperty("订单明细表")
    private List<CommitOrderItemRequest> itemList;

    @ApiModelProperty("商品金额,单位：分")
    @NotEmpty(message = "商品金额 不能为空")
    private Integer productFee;

    @ApiModelProperty("邮费金额,单位：分")
    @NotEmpty(message = "邮费金额 不能为空")
    private Integer postFee;

    @ApiModelProperty("实际支付金额,单位：分")
    @NotEmpty(message = "实际支付金额 不能为空")
    private Integer payAmount;
}
