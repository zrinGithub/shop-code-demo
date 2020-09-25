package com.zr.order.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Description:
 * 这里做一个简单的请求测试，所以没有啥用户信息，只有sku信息
 * @author zhangr
 * 2020/9/24 15:46
 */
@ApiModel("提交订单-请求体")
@Data
public class CommitOrderItemRequest {
    @ApiModelProperty("SKU ID")
    @NotEmpty(message = "SKU 不能为空")
    private String skuId;

    @ApiModelProperty("购买数量")
    @NotEmpty(message = "购买数量 不能为空")
    private Integer num;
}
