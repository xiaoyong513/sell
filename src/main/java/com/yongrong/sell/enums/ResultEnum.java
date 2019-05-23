package com.yongrong.sell.enums;

import lombok.Getter;

/**
 * Created by changyong on 2019/2/11.
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数不正确"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),

    ORDER_NOT_EXIST(20, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(21, "订单不存在"),
    ORDER_STATUS_ERROR(22, "订单状态不正确"),
    ORDER_UPDATE_FAIL(23, "订单更新失败"),
    ORDER_DETAIL_EMPTY(24, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(25, "订单支付状态不正确"),
    ORDER_OWNER_ERROR(26, "该订单不属于当前用户"),

    CART_EMPTY(30, "购物车不能为空"),


    WECHAT_MP_ERROR(40, "微信公众号方面的错误"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
