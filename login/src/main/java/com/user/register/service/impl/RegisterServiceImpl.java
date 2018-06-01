package com.user.register.service.impl;

import com.user.common.*;
import com.user.register.dao.TabAppMapper;
import com.user.register.dao.TabUserMapper;
import com.user.register.service.RegisterService;
import com.user.register.vo.TabAppVO;
import com.user.register.vo.TabUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:   用户注册实现类
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    public static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Resource
    private TabUserMapper tabUserMapper;

    @Resource
    private TabAppMapper tabAppMapper;

    @Transactional
    @Override
    public ResultMessage<TabUserVO> userRegister(String appId, String phoneNo, String userName,
                                                 String password, Integer idCardType, String idCardNo,
                                                 String email, String provCode, String cityCode, String areaCode) {
        ParamUtils.checkParamsIsNull(appId, phoneNo, userName, password, idCardNo, email, provCode, cityCode, areaCode);

        TabUserVO user = tabUserMapper.selectByPhoneNoAndAppId(phoneNo, appId);
        if (user != null) {
            return new ResultMessage<>(ReturnCode.USER_HAS_REGISTED, ReturnCode.USER_HAS_REGISTED_MSG);
        }

        TabAppVO app = tabAppMapper.selectByPrimaryKey(appId);
        if (app == null) {
            return new ResultMessage<>(ReturnCode.APP_IS_NOT_EXIT, ReturnCode.APP_IS_NOT_EXIT_MSG);
        }

        user = new TabUserVO();
        user.setUserNo(RandomUtils.generateNumber(10));
        user.setAppId(appId);
        user.setPhoneNo(phoneNo);
        user.setUserName(userName);
        String salt = RandomUtils.generateSalt(16);
        user.setPwd(EncryptUtils.encryptSHA512(password,salt));
        user.setSalt(salt);
        user.setIdCardType(idCardType);
        user.setIdCardNo(idCardNo);
        user.setEmail(email);
        user.setProvCode(provCode);
        user.setCityCode(cityCode);
        user.setAreaCode(areaCode);
        user.setUserLevel(0);
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        tabUserMapper.insert(user);
        user.setSalt(null);
        user.setPwd(null);
        logger.info("用户注册成功："+ user);
        ResultMessage<TabUserVO> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS,ReturnCode.SUCCESS_MSG);
        resultMessage.setData(user);
        return resultMessage;
    }
}
