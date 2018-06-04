package com.user.manager.service;

import com.user.manager.vo.RolePermissionVO;
import com.user.manager.vo.TabPermissionVO;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/2
 * desc:    角色授权业务类
 */
public interface AuthRoleService {

    /**
     * 角色授权权限
     * @param roleId：角色id
     * @param permissionId: 权限id
     * @return
     */
    int authRole(Integer roleId,Long permissionId);

    /**
     * 批量角色授权权限
     * @param roleId：权限id
     * @param permissionIds: 权限列表
     * @return
     */
    int authRoles(Integer roleId, List<Long> permissionIds);

    /**
     * 取消角色授权
     * @param rolePermissionId：角色权限id
     * @return
     */
    int canceAuthRole(Integer rolePermissionId);

    /**
     * 批量取消角色授权
     * @param roleId：角色id
     * @param permissionIds:权限id列表
     * @return
     */
    int canceAuthRoles(Integer roleId, List<Integer> permissionIds);

    /**
     * 获取角色权限列表
     * @param roleId：角色id
     * @return
     */
    List<RolePermissionVO> findRolePermissions(Integer roleId);

}
