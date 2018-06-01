package com.user.register.controller;

import com.user.common.ResultMessage;
import com.user.register.service.RegisterService;
import com.user.register.vo.TabUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:   用户注册
 */
@Api("用户注册")
@RestController
@RequestMapping("/user")
public class RegisterController {
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private RegisterService registerService;

    @ApiOperation("用户注册接口")
    @RequestMapping(value = "/register/{appId}",method = RequestMethod.POST)
    public ResultMessage<TabUserVO> register(@ApiParam("应用id") @PathVariable("appId") String appId,
                                             @ApiParam("手机号码") @RequestParam String phoneNo,
                                             @ApiParam("用户名") @RequestParam String userName,
                                             @ApiParam("用户密码") @RequestParam String password,
                                             @ApiParam("证件类型：1-身份证") @RequestParam Integer idCardType,
                                             @ApiParam("证件号码") @RequestParam String idCardNo,
                                             @ApiParam("邮箱地址") @RequestParam  String email,
                                             @ApiParam("省代码") @RequestParam String provCode,
                                             @ApiParam("市代码") @RequestParam String cityCode,
                                             @ApiParam("区、县代码") @RequestParam String areaCode) {
        ResultMessage<TabUserVO> resultMessage = registerService.userRegister(appId,phoneNo,userName,password,idCardType,idCardNo,email,provCode,cityCode,areaCode);
        return resultMessage;
    }
}
