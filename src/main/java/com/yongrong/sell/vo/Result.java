package com.yongrong.sell.vo;

import lombok.Data;

/**
 * Created by changyong on 2019/1/23.
 */
@Data
public class Result<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体内容
     */
    private T data;

}
