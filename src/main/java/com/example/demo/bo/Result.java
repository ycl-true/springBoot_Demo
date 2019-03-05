package com.example.demo.bo;

public class Result<T> {
    Integer code;
    String mesg;
    T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(Integer code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
    }

    public Result() {
    }
}
