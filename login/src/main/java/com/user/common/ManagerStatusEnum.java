package com.user.common;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:    信息状态枚举
 */
public enum  ManagerStatusEnum {

    LOCKED("0"),NORMAL("1"),ALL("2");

    private String value;

    private ManagerStatusEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
