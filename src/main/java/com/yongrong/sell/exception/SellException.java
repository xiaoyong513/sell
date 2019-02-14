package com.yongrong.sell.exception;

import com.yongrong.sell.enums.ResultEnum;

/**
 * Created by changyong on 2019/2/11.
 */
public class SellException extends RuntimeException{

    private Integer code;

     public SellException(ResultEnum resultEnum) {
         super(resultEnum.getMessage());
         this.code = resultEnum.getCode();
     }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
