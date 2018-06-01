package com.user.common;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:   返回码定义
 */
public class ReturnCode {
    /**
     * 成功
     */
    public static final String SUCCESS = "0000";

    /**
     * 成功说明
     */
    public static final String SUCCESS_MSG = "成功";

    /**
     * 系统异常
     */
    public static final String ERROR = "9999";

    /**
     * 系统异常说明
     */
    public static final String ERROR_MSG = "系统异常!";

    /**
     * 参数未传
     */
    public static final String PARAM_NO_SEND = "0001";
    /**
     * 参数未传说明
     */
    public static final String PARAM_NO_SEND_MSG = "参数未传!";
    /**
     * 参数未还，必须要要传一个
     */
    public static final String PARAM_NO_SEND_MSG_NOTICE = "参数未传!必须要传一个不为null的参数";

    /**
     * 用户已经注册
     */
    public static final String USER_HAS_REGISTED = "0002";
    /**
     * 用户已经注册说明
     */
    public static final String USER_HAS_REGISTED_MSG = "用户已经注册!";

    /**
     * 应用不存在
     */
    public static final String APP_IS_NOT_EXIT = "0003";
    /**
     * 应用不存在说明
     */
    public static final String APP_IS_NOT_EXIT_MSG = "用户不存在!";

    /**
     * 用户等传送错误 只能是1 或者2
     */
    public static final String USER_LEVEL_ERROR = "0004";

    /**
     * 错误传入错误说明
     */
    public static final String PARAM_ERROR = "参数传送错误，请检测参数！";

}
