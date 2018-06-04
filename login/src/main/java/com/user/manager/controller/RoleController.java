package com.user.manager.controller;

import com.user.common.PageInfo;
import com.user.common.ResultMessage;
import com.user.common.ReturnCode;
import com.user.manager.service.RoleService;
import com.user.manager.vo.TabPermissionVO;
import com.user.manager.vo.TabRoleVO;
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
 * desc:    角色管理
 */
@Api("角色管理")
@RestController
@RequestMapping("/manager")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation("添加角色接口")
    @RequestMapping(path = "/addRole", method = RequestMethod.POST)
    public ResultMessage<String> addRole(@ApiParam("角色名字") @RequestParam String name,
                                         @ApiParam("角色类型") @RequestParam String type) {
        roleService.addRole(name, type);

        return new ResultMessage<>(ReturnCode.SUCCESS, "角色添加成功!");
    }

    @ApiOperation("删除角色")
    @RequestMapping(path = "/delRole", method = RequestMethod.DELETE)
    public ResultMessage<String> delRole(@ApiParam("角色id") @RequestParam Integer id) {
        roleService.delRole(id);

        return new ResultMessage<>(ReturnCode.SUCCESS, "删除角色成功!");
    }

    @ApiOperation("修改角色")
    @RequestMapping(path = "/changeRole", method = RequestMethod.POST)
    public ResultMessage<TabRoleVO> changeRole(@ApiParam("角色id") @RequestParam Integer id,
                                               @ApiParam("角色名字") @RequestParam String name,
                                               @ApiParam("角色类型") @RequestParam String type,
                                               @ApiParam("角色是否可用0：不可用,1: 可用") @RequestParam String available) {
        TabRoleVO roleVO = roleService.changeRole(id, name, type, available);

        ResultMessage<TabRoleVO> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "修改角色信息成功!");

        resultMessage.setData(roleVO);

        return resultMessage;
    }

    @ApiOperation("根据角色id查询角色接口")
    @RequestMapping(path = "/findRole", method = RequestMethod.GET)
    public ResultMessage<TabRoleVO> findRole(@ApiParam("角色id") @RequestParam Integer id){
        TabRoleVO data = roleService.findRole(id);

        ResultMessage<TabRoleVO> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "查找角色信息成功!");

        resultMessage.setData(data);

        return resultMessage;
    }

    @ApiOperation("条件查询角色接口")
    @RequestMapping(path = "/findRoles", method = RequestMethod.GET)
    public ResultMessage<PageInfo<List<TabRoleVO>>> findRoles(@ApiParam("角色id") @RequestParam Integer id,
                                                             @ApiParam("角色名字") @RequestParam String name,
                                                             @ApiParam("角色类型") @RequestParam String type,
                                                             @ApiParam("角色是否可用0：不可用,1: 可用") @RequestParam String available,
                                                             @ApiParam("页码") @RequestParam Integer pageNum,
                                                             @ApiParam("每页记录条数") @RequestParam Integer pageSize) {
        PageInfo<List<TabRoleVO>> data = roleService.findRoles(name, type, available, pageNum, pageSize);

        ResultMessage<PageInfo<List<TabRoleVO>>> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "分页查找角色信息成功!");

        resultMessage.setData(data);

        return resultMessage;
    }


    @ApiOperation("分页显示角色接口")
    @RequestMapping(path = "/showRoles", method = RequestMethod.GET)
    public ResultMessage<PageInfo<List<TabRoleVO>>> showRoles(@ApiParam("角色是否可用0：不可用,1: 可用 2：所有") @RequestParam String available,
                                                              @ApiParam("页码") @RequestParam Integer pageNum,
                                                              @ApiParam("每页记录条数") @RequestParam Integer pageSize) {
        PageInfo<List<TabRoleVO>> data = roleService.showRoles(available, pageNum, pageSize);

        ResultMessage<PageInfo<List<TabRoleVO>>> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "分页获取角色成功!");

        resultMessage.setData(data);

        return resultMessage;
    }


}
