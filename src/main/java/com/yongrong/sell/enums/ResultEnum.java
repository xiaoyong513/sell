package com.yongrong.sell.enums;

import lombok.Getter;

/**
 * Created by changyong on 2019/2/11.
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),

    ORDER_NOT_EXIST(20, "订单不存在"),


    ORDER_DETAIL_NOT_EXIST(30, "订单不存在"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
