package com.user.manager.controller;

import com.user.common.PageInfo;
import com.user.common.ParamUtils;
import com.user.common.ResultMessage;
import com.user.common.ReturnCode;
import com.user.manager.service.PermissionService;
import com.user.manager.vo.TabPermissionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: xiao
 * date:   2018/5/30
 * desc:    资源权限管理
 */
@Api("资源权限管理")
@RestController
@RequestMapping("/manager")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation("添加权限接口")
    @RequestMapping(path = "/addPermission", method = RequestMethod.POST)
    public ResultMessage<TabPermissionVO> addPermission(@ApiParam("权限名字") @RequestParam String name,
                                                        @ApiParam("权限类型") @RequestParam String type,
                                                        @ApiParam("资源url") @RequestParam String url,
                                                        @ApiParam("应用名称") @RequestParam String appName) {
        ParamUtils.checkParamsIsNull(name, type, url);

        TabPermissionVO permissionVO = permissionService.addPermission(name, type, url, appName);

        ResultMessage<TabPermissionVO> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "添加权限成功!");

        resultMessage.setData(permissionVO);

        return resultMessage;
    }

    @ApiOperation("删除权限接口")
    @RequestMapping(path = "/delPermission", method = RequestMethod.DELETE)
    public ResultMessage<String> delPermission(@ApiParam("权限id") @RequestParam Long id) {
        ParamUtils.checkParamsIsNull(id);

        permissionService.delPermission(id);

        return new ResultMessage<>(ReturnCode.SUCCESS, "删除权限成功!");
    }


    @ApiOperation("修改权限接口")
    @RequestMapping(path = "/changePermission", method = RequestMethod.POST)
    public ResultMessage<String> changePermission(@ApiParam("权限id") @RequestParam Long id,
                                                  @ApiParam("权限名字") @RequestParam String name,
                                                  @ApiParam("权限类型") @RequestParam String type,
                                                  @ApiParam("权限url") @RequestParam String url,
                                                  @ApiParam("应用名称") @RequestParam String appName,
                                                  @ApiParam("是否可用1：可用 ,0:不可用") @RequestParam String available) {
        ParamUtils.checkParamsIsNull(id);

        ParamUtils.checkParamsExits(name, type, url, available);

        permissionService.changePermission(id, name, type, url, appName, available);

        return new ResultMessage<>(ReturnCode.SUCCESS, "修改权限成功!");
    }

    @ApiOperation("条件查询权限信息接口")
    @RequestMapping(path = "/findPermission", method = RequestMethod.GET)
    public ResultMessage<TabPermissionVO> findPermission(@ApiParam("权限id") @RequestParam Long id){
        TabPermissionVO permission = permissionService.findPermission(id);

        ResultMessage<TabPermissionVO> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "查询权限信息成功!");

        resultMessage.setData(permission);

        return resultMessage;
    }

    @ApiOperation("条件查询权限信息接口")
    @RequestMapping(path = "/findPermissions", method = RequestMethod.GET)
    public ResultMessage<PageInfo<List<TabPermissionVO>>> findPermissions(@ApiParam("权限id") @RequestParam Long id,
                                                                         @ApiParam("权限名字") @RequestParam String name,
                                                                         @ApiParam("权限类型") @RequestParam String type,
                                                                         @ApiParam("权限url") @RequestParam String url,
                                                                         @ApiParam("应用名称") @RequestParam String appName,
                                                                         @ApiParam("是否可用1：可用 ,0:不可用") @RequestParam String available,
                                                                         @ApiParam("页码从1开始") @RequestParam Integer pageNum,
                                                                         @ApiParam("每页记录条数") @RequestParam Integer pageSize) {
        PageInfo<List<TabPermissionVO>> permissions = permissionService.findPermissions(id, name, type, url, appName, available, pageNum, pageSize);

        ResultMessage<PageInfo<List<TabPermissionVO>>> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "查询权限信息成功!");

        resultMessage.setData(permissions);

        return resultMessage;
    }


    @ApiOperation("分页显示所有权限接口")
    @RequestMapping(path = "/showPermissions", method = RequestMethod.GET)
    public ResultMessage<PageInfo<List<TabPermissionVO>>> showPermissions(@ApiParam("是否可用0:不可用, 1：可用 ,2:所有") @RequestParam String available,
                                                                          @ApiParam("页码") @RequestParam Integer pageNum,
                                                                          @ApiParam("记录条数") @RequestParam Integer pageSize) {
        ParamUtils.checkParamsIsNull(available);

        PageInfo<List<TabPermissionVO>> permissions = permissionService.showPermissions(available, pageNum, pageSize);

        ResultMessage<PageInfo<List<TabPermissionVO>>> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "分页获取权限成功!");

        resultMessage.setData(permissions);

        return resultMessage;
    }
}
