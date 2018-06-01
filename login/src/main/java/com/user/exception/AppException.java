package com.user.exception;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:   系统自定义定义异常
 */
public class AppException extends RuntimeException {
    private String code;
    private String msg;

    public AppException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AppException() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
