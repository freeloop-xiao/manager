package com.user.manager.controller;

import com.user.common.PageInfo;
import com.user.common.ResultMessage;
import com.user.common.ReturnCode;
import com.user.manager.service.AuthAdminService;
import com.user.manager.vo.TabAdminVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:   管理员授权
 */
@Api("管理员授权管理")
@RestController
@RequestMapping("/manager")
public class AuthAdminController {

    @Autowired
    private AuthAdminService authAdminService;

    @ApiOperation("用户授权角色")
    @RequestMapping(path = "/authAdmin", method = RequestMethod.POST)
    public ResultMessage<String> authRole(@ApiParam("管理员id") @RequestParam String adminId,
                                          @ApiParam("角色id") @RequestParam Integer roleId) {
        authAdminService.authRole(adminId,roleId);
        ResultMessage<String> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "用户授权角色成功!");
        return resultMessage;
    }

    @ApiOperation("用户批量授权角色")
    @RequestMapping(path = "/authAdmins/{adminId}", method = RequestMethod.POST)
    public ResultMessage<String> authAdmins(@ApiParam("管理员id") @PathVariable("adminId") String adminId,
                                          @ApiParam("角色id列表") @RequestParam List<Integer> roleIds) {
        authAdminService.authRoles(adminId,roleIds);
        ResultMessage<String> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "用户授权角色成功!");
        return resultMessage;
    }

    @ApiOperation("取消用户授权角色")
    @RequestMapping(path = "/canceAdmin", method = RequestMethod.DELETE)
    public ResultMessage<String> canceAdmin(@ApiParam("管理员角色授权id") @RequestParam Integer adminRoleId) {
        authAdminService.canceRole(adminRoleId);
        ResultMessage<String> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "用户取消角色授权!");
        return resultMessage;
    }


    @ApiOperation("批量取消用户授权角色")
    @RequestMapping(path = "/canceAdmins", method = RequestMethod.DELETE)
    public ResultMessage<String> canceAdmins(@ApiParam("角色id列表") @RequestParam List<Integer> adminRoleIds) {
        authAdminService.canceRoles(adminRoleIds);
        ResultMessage<String> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "批量取消用户角色授权!");
        return resultMessage;
    }
}
