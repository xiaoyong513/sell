package com.yongrong.sell.utils;

import com.yongrong.sell.vo.Result;

/**
 * Created by changyong on 2019/1/23.
 */
public class ResultUtils {

    public static Result success(Object o) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage("success");
        result.setData(o);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
