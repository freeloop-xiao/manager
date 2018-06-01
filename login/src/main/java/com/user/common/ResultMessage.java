package com.user.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:
 */
@ApiModel(description = "统一返回值")
public class ResultMessage<T> {
    public ResultMessage(){}

    public ResultMessage(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @ApiModelProperty("返回码：0000 正常返回")
    private String code;

    @ApiModelProperty("消息说明")
    private String msg;

    @ApiModelProperty("返回数据")
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
