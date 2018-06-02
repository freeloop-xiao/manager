package com.user.manager.service;

import com.user.manager.vo.TabPermissionVO;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/2
 * desc:    角色授权业务类
 */
public interface AuthRoleService {

    int authRole(Integer roleId,Long permissionId);

    int authRoles(Integer roleId, List<Long> permissionIds);

    int canceAuthRole(Integer rolePermissionId);

    int canceAuthRoles(Integer roleId, List<Long> permissionIds);

    List<TabPermissionVO> findRolePermissions(Integer roleId);

}
