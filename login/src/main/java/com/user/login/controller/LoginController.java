package com.user.login.controller;

import com.user.common.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:   用户登录控制器
 */
@Api("用户登录")
@RestController
@RequestMapping("/user")
public class LoginController {

    @ApiOperation("用户账户密码登录接口")
    @RequestMapping(value = "/login/{appId}",method = RequestMethod.POST)
    public ResultMessage<String> login(@ApiParam("应用id") @PathVariable("appId") String appId,
                                       @ApiParam("账户(手机号码)") @RequestParam String account,
                                       @ApiParam("密码") @RequestParam String password){

        return null;
    }



}
