package com.example.demo.util;

import com.example.demo.bo.Result;

public class ApplyUtil {
    public static Result getResult(Integer code, String msg, Object data){
        return new Result(code, msg, data);
    }
}
