package com.user.manager.service;

import com.user.common.PageInfo;
import com.user.manager.vo.TabAdminVO;
import com.user.manager.vo.TabPermissionVO;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:  后台用户管理接口
 */
public interface AdminService {

    /**
     *
     * @param name：管理员名字
     * @param email：邮箱地址
     * @param phoneNo：电话号码
     * @param pwd：密码
     * @param userLevel：用户等级 0：普通用户 1:超级用户
     * @param appId：应用id
     * @param remark: 备注
     * @return
     */
    int addAdmin(String name, String email, String phoneNo, String pwd, Integer userLevel, String appId, String remark);

    /**
     * 删除管理员id
     * @param id:管理员id
     * @return
     */
    int delAdmin(String id);

    /**
     * 修改管理员信息
     * @param id：管理员id
     * @param name: 名字
     * @param email：邮箱地址
     * @param phoneNo：手机号码
     * @param userLevel：用户等级 0：普通用户 1：超级用户
     * @param appId：应用id
     * @param remark: 备注
     * @param available：是否可用 0：不可用 1：可用
     * @return
     */
    TabAdminVO changeAdmin(String id,String name, String email, String phoneNo, Integer userLevel, String appId, String remark, String available);

    /**
     * 查看管理员信息
     * @param id：管理员id
     * @return
     */
    TabAdminVO findAdmin(String id);

    /**
     * 查找管理员信息列表
     * @param name：名字
     * @param email：邮箱地址
     * @param phoneNo: 电话号码
     * @param userLevel：管理员用户等级
     * @param available：是否可用 1：可用 0：不可用
     * @param appId：应用id
     * @param pageNum ：页码
     * @param pageSize： 每页记录条数
     * @return
     */
    PageInfo<List<TabAdminVO>> findAdmins(String name, String email, String phoneNo, Integer userLevel, String available, String appId, Integer pageNum, Integer pageSize);

    /**
     * 查看管理员用户信息
     * @param available:是否可用 0：不可用 1：可用
     * @param pageNum：页码
     * @param pageSize：页面尺寸
     * @return
     */
    PageInfo<List<TabAdminVO>> showAdmins(String available, Integer pageNum, Integer pageSize);

    /**
     * 根据管理员id查找对于权限
     * @param adminId：管理员id
     * @param pageNum: 页码
     * @param pageSize：页记录条数
     * @return
     */
    PageInfo<List<TabPermissionVO>> showAdminPermissions(String adminId, Integer pageNum, Integer pageSize);
}
