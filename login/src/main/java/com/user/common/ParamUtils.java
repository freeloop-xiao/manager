package com.user.common;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:   参数公共类
 */
public class ParamUtils {

    /**
     * 检查所有参数都不能为null
     * @param arg
     * @param <T>
     * @return
     */
    public static <T> ResultMessage checkParamsIsNull(T ... arg){
        for (T t:arg) {
            if (t == null){
                return new ResultMessage(ReturnCode.PARAM_NO_SEND,ReturnCode.PARAM_NO_SEND_MSG);
            }
        }
        return null;
    }

    /**
     * 存在一个参数不为null
     * @param arg
     * @param <T>
     * @return
     */
    public static <T> ResultMessage checkParamsExits(T ... arg){
        for (T t:arg) {
            if (t != null){
                return null;
            }
        }
        return new ResultMessage(ReturnCode.PARAM_NO_SEND,ReturnCode.PARAM_NO_SEND_MSG_NOTICE);

    }

}
