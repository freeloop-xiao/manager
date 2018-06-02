package com.user.manager.controller;

import com.user.common.ParamUtils;
import com.user.common.ResultMessage;
import com.user.common.ReturnCode;
import com.user.manager.service.AuthRoleService;
import com.user.manager.vo.TabPermissionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:   角色授权
 */
@Api("角色授权管理")
@RestController
@RequestMapping("/manager")
public class AuthRoleController {
    @Autowired
    private AuthRoleService authRoleService;

    @ApiOperation("角色授权接口")
    @RequestMapping(path = "/authRole", method = RequestMethod.POST)
    public ResultMessage<String> authRole(@ApiParam("角色id") @RequestParam Integer roleId,
                                          @ApiParam("权限id") @RequestParam Long permissionId){
        ParamUtils.checkParamsIsNull(roleId);
        ParamUtils.checkParamsIsNull(permissionId);
        authRoleService.authRole(roleId, permissionId);
        return new ResultMessage<>(ReturnCode.SUCCESS, "角色授权成功!");
    }

    @ApiOperation("批量授权")
    @RequestMapping(path = "/authRoles/{roleId}", method = RequestMethod.POST)
    public ResultMessage<String> authRoles(@ApiParam("角色id") @PathVariable("roleId") Integer roleId,
                                           @ApiParam("权限id List") @RequestBody List<Long> permissionIds){
        ParamUtils.checkParamsIsNull(permissionIds);
        authRoleService.authRoles(roleId, permissionIds);
        return new ResultMessage<>(ReturnCode.SUCCESS, "角色批量授权成功!");
    }

    @ApiOperation("取消角色授权接口")
    @RequestMapping(path = "/canceAuthRole", method = RequestMethod.DELETE)
    public ResultMessage<String> canceAuthRole(@ApiParam("授权id") @RequestParam Integer rolePermissionId){
        ParamUtils.checkParamsIsNull(rolePermissionId);
        authRoleService.canceAuthRole(rolePermissionId);
        return new ResultMessage<>(ReturnCode.SUCCESS, "取消角色授权成功！");
    }

    @ApiOperation("角色批量取消授权接口")
    @RequestMapping(path = "/canceAuthRoles/{roleId}", method = RequestMethod.DELETE)
    public ResultMessage<String> canceAuthRoles(@ApiParam("角色Id") @PathVariable("roleId") Integer roleId,
                                                @ApiParam("权限id列表") @RequestBody List<Long> permissionIds){
        ParamUtils.checkParamsIsNull(permissionIds);
        authRoleService.canceAuthRoles(roleId, permissionIds);
        return new ResultMessage<>(ReturnCode.SUCCESS, "角色批量取消授权成功！");
    }

    @ApiOperation("查看角色授权")
    @RequestMapping(path = "/findRoleAuths", method = RequestMethod.GET)
    public ResultMessage<List<TabPermissionVO>> findRoleAuths(@ApiParam("角色id") @RequestParam Integer roleId){
        List<TabPermissionVO> data = authRoleService.findRolePermissions(roleId);
        ResultMessage<List<TabPermissionVO>> resultMessage = new ResultMessage(ReturnCode.SUCCESS, "获取角色授权成功!");
        resultMessage.setData(data);
        return resultMessage;
    }
}
