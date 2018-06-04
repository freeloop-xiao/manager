package com.user.manager.service;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/4
 * desc:    用户授权角色接口
 */
public interface AuthAdminService {
    /**
     * 用户角色授权
     * @param adminId：管理员id
     * @param roleId: 角色id
     * @return
     */
    int authRole(String adminId, Integer roleId);

    /**
     * 批量用户授权角色
     * @param adminId：管理员id
     * @param roleIds: 角色id列表
     * @return
     */
    int authRoles(String adminId, List<Integer> roleIds);

    /**
     * 取消用户授权角色
     * @param adminRoleId：用户权限授权id
     * @return
     */
    int canceRole(Integer adminRoleId);

    /**
     * 批量取消用户管理员角色授权
     * @param adminRoleIds
     * @return
     */
    int canceRoles(List<Integer> adminRoleIds);

}
