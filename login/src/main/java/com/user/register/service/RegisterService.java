package com.user.register.service;

import com.user.common.ResultMessage;
import com.user.register.vo.TabUserVO;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:    用户注册业务类
 */
public interface RegisterService {

    /**
     * 用户注册
     * @param appId :应用id
     * @param phoneNo :电话号码
     * @param userName ：用户名
     * @param password ：密码
     * @param idCardType ：证件类型
     * @param idCardNo  ：证件号
     * @param email ：邮件地址
     * @param provCode  ：省编编码
     * @param cityCode  ：市编码
     * @param areaCode  ：区、县编码
     * @return
     */
    ResultMessage<TabUserVO> userRegister(String appId, String phoneNo, String userName, String password, Integer idCardType, String idCardNo, String email, String provCode, String cityCode, String areaCode);
}
