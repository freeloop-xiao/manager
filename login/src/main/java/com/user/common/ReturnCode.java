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

    /**
     * 角色不存在
     */
    public static final String ROLE_IS_NOT_EXIST = "0005";
    /**
     * 角色不存在消息提醒
     */
    public static final String ROLE_IS_NOT_EXIST_MSG = "角色不存在！";

    /**
     * 权限不存在
     */
    public static final String PERMISSION_IS_NOT_EXIST = "0006";
    /**
     * 权限不存在提醒
     */
    public static final String PERMISSION_IS_NOT_EXIST_MSG = "权限不存在!";

    /**
     * 角色已经授权
     */
    public static final String PERMISSION_IS_EXIST = "0007";
    /**
     * 角色已经授权提醒
     */
    public static final String PERMISSION_IS_EXIST_MSG = "该角色已经拥有该权限!";


    /**
     * 用户已经拥有角色重复授权
     */
    public static final String ROLE_IS_EXIST = "0008";
    /**
     * 用户已经拥有角色重复授权提醒
     */
    public static final String ROLE_IS_EXIST_MSG = "用户已经拥有该角色!";


}
