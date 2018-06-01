package com.user.manager.controller;

import com.user.common.PageInfo;
import com.user.common.ParamUtils;
import com.user.common.ResultMessage;
import com.user.common.ReturnCode;
import com.user.manager.service.AdminService;
import com.user.manager.vo.TabAdminVO;
import com.user.manager.vo.TabPermissionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: xiao
 * date:   2018/5/30
 * desc:    后台管理员管理
 */
@Api("管理员管理")
@RestController
@RequestMapping("/manager")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("添加管理员接口")
    @RequestMapping(path = "/addAdmin", method = RequestMethod.POST)
    public ResultMessage<String> addAdmin(@ApiParam("管理员名字") @RequestParam String name,
                                          @ApiParam("管理员邮箱") @RequestParam String email,
                                          @ApiParam("管理员电话") @RequestParam String phoneNo,
                                          @ApiParam("管理员密码") @RequestParam String pwd,
                                          @ApiParam("管理员等级1：普通管理账户，2：超级管理员") @RequestParam Integer userLevel,
                                          @ApiParam("管理员管理的appId") @RequestParam String appId,
                                          @ApiParam("管理员备注") @RequestParam String remark) {
        ParamUtils.checkParamsIsNull(name, email, phoneNo, pwd);
        adminService.addAdmin(name, email, phoneNo, pwd, userLevel, appId, remark);
        return new ResultMessage<>(ReturnCode.SUCCESS, "添加管理员账户成功!");
    }


    @ApiOperation("删除管理员接口")
    @RequestMapping(path = "/delAdmin", method = RequestMethod.DELETE)
    public ResultMessage<String> addAdmin(@ApiParam("管理员id") @RequestParam String id) {
        ParamUtils.checkParamsIsNull(id);
        adminService.delAdmin(id);
        return new ResultMessage<>(ReturnCode.SUCCESS, "删除管理员账户成功!");
    }

    @ApiOperation("修改管理员(包括禁用)")
    @RequestMapping(path = "/changeAdmin", method = RequestMethod.POST)
    public ResultMessage<TabAdminVO> changeAdmin(@ApiParam("管理员id") @RequestParam String id,
                                                 @ApiParam("管理员名字") @RequestParam String name,
                                                 @ApiParam("管理员邮箱") @RequestParam String email,
                                                 @ApiParam("管理员电话") @RequestParam String phoneNo,
                                                 @ApiParam("管理员等级1：普通管理账户，2：超级管理员") @RequestParam Integer userLevel,
                                                 @ApiParam("管理员管理的appId") @RequestParam String appId,
                                                 @ApiParam("是否可用0：不可用 1：可用") @RequestParam String available,
                                                 @ApiParam("管理员备注") @RequestParam String remark) {
        ParamUtils.checkParamsIsNull(id);
        ParamUtils.checkParamsExits(name, email, phoneNo, appId, remark);
        TabAdminVO tabAdminVO = adminService.changeAdmin(id, name, email, phoneNo, userLevel, appId, remark, available);
        ResultMessage<TabAdminVO> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "修改管理员账户成功!");
        resultMessage.setData(tabAdminVO);
        return resultMessage;
    }

    @ApiOperation("根据id查询用户信息接口")
    @RequestMapping(path = "/findAdmin", method = RequestMethod.POST)
    public ResultMessage<TabAdminVO> findAdmin(@ApiParam("管理员id") @RequestParam String id) {
        ParamUtils.checkParamsIsNull(id);
        TabAdminVO tabAdminVO = adminService.findAdmin(id);
        ResultMessage<TabAdminVO> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "查询管理员账户成功!");
        resultMessage.setData(tabAdminVO);
        return resultMessage;
    }


    @ApiOperation("查询管理员用户信息接口")
    @RequestMapping(path = "/findAdmins", method = RequestMethod.POST)
    public ResultMessage<PageInfo<List<TabAdminVO>>> findAdmins(
            @ApiParam("管理员名字") @RequestParam String name,
            @ApiParam("管理员邮箱") @RequestParam String email,
            @ApiParam("管理员电话") @RequestParam String phoneNo,
            @ApiParam("管理员等级1：普通管理账户，2：超级管理员") @RequestParam Integer userLevel,
            @ApiParam("管理员管理的appId") @RequestParam String appId,
            @ApiParam("是否可用0：不可用 1：可用") @RequestParam String available,
            @ApiParam("页码") @RequestParam Integer pageNum,
            @ApiParam("每页记录条数") @RequestParam Integer pageSize) {
        ParamUtils.checkParamsExits(name, email, phoneNo, appId, String.valueOf(userLevel),available);
        PageInfo<List<TabAdminVO>> pageInfo = adminService.findAdmins(name, email, phoneNo, userLevel, available, appId, pageNum, pageSize);
        ResultMessage<PageInfo<List<TabAdminVO>>> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "查找管理员账户成功!");
        resultMessage.setData(pageInfo);
        return resultMessage;
    }

    @ApiOperation("分页显示管理员信息接口")
    @RequestMapping(path = "/showAdmins", method = RequestMethod.POST)
    public ResultMessage<PageInfo<List<TabAdminVO>>> showAdmins(@ApiParam("是否可用 1：可用 0：不可用") @RequestParam String available,
                                                @ApiParam("页码") @RequestParam Integer pageNum,
                                                @ApiParam("每页记录数") @RequestParam Integer pageSize) {
        PageInfo<List<TabAdminVO>> pageInfo = adminService.showAdmins(available, pageNum, pageSize);
        ResultMessage<PageInfo<List<TabAdminVO>>> resultMessage = new ResultMessage<>(ReturnCode.SUCCESS, "查询管理员账户成功!");
        resultMessage.setData(pageInfo);
        return resultMessage;
    }

}
