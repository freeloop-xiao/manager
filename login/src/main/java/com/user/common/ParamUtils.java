package com.user.common;

import com.user.exception.AppException;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:   参数公共类
 */
public class ParamUtils {

    /**
     * 检查所有参数都不能为null
     * @param arg
     * @return
     */
    public static <T> void checkParamsIsNull(T ... arg){
        for (T t:arg) {
            if (t == null){
                throw new AppException(ReturnCode.PARAM_NO_SEND,ReturnCode.PARAM_NO_SEND_MSG);
            }
        }
    }

    /**
     * 存在一个参数不为null
     * @param arg
     * @return
     */
    public static <T> void checkParamsExits(T ... arg){
        for (T t:arg) {
            if (t != null){
                return;
            }
        }
        throw new AppException(ReturnCode.PARAM_NO_SEND,ReturnCode.PARAM_NO_SEND_MSG_NOTICE);
    }

}
