package com.example.demo.exception;

import com.example.demo.enums.ResultEnums;

public class UserException extends RuntimeException{
    // spring只会处理RuntimeException 进行事务回滚

    private Integer code;

    public UserException(ResultEnums enums) {
        super(enums.getMsg());
        this.code = enums.getCode();
    }

    public UserException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
