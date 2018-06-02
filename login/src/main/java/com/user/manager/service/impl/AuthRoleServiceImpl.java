package com.user.manager.service.impl;

import com.user.common.ReturnCode;
import com.user.exception.AppException;
import com.user.manager.dao.TabPermissionMapper;
import com.user.manager.dao.TabRoleMapper;
import com.user.manager.dao.TabRolePermissionMapper;
import com.user.manager.service.AuthRoleService;
import com.user.manager.vo.TabPermissionVO;
import com.user.manager.vo.TabRolePermissionVO;
import com.user.manager.vo.TabRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * author: xiao
 * date:   2018/6/2
 * desc:
 */
@Service
public class AuthRoleServiceImpl implements AuthRoleService {
    @Autowired
    private TabRolePermissionMapper tabRolePermissionMapper;

    @Autowired
    private TabRoleMapper tabRoleMapper;

    @Autowired
    private TabPermissionMapper tabPermissionMapper;

    @Override
    public int authRole(Integer roleId, Long permissionId) {

        TabRoleVO tabRoleVO = tabRoleMapper.selectByPrimaryKey(roleId);
        if (tabRoleVO == null){
            throw new AppException(ReturnCode.ROLE_IS_NOT_EXIST, ReturnCode.ROLE_IS_NOT_EXIST_MSG);
        }

        TabPermissionVO tabPermissionVO = tabPermissionMapper.selectByPrimaryKey(permissionId);
        if (tabPermissionVO == null){
            throw new AppException(ReturnCode.PERMISSION_IS_NOT_EXIST, ReturnCode.PERMISSION_IS_NOT_EXIST_MSG);
        }

        TabRolePermissionVO tabRolePermissionVO = tabRolePermissionMapper.selectByRoleIdAndPermissionId(roleId, permissionId);
        if (tabRolePermissionVO == null){
            throw new AppException(ReturnCode.PERMISSION_IS_EXIST, ReturnCode.PERMISSION_IS_EXIST_MSG);
        }
        TabRolePermissionVO tabRolePermission = new TabRolePermissionVO();
        tabRolePermission.setPermissionId(permissionId);
        tabRolePermission.setRoleId(roleId);
        return tabRolePermissionMapper.insertSelective(tabRolePermission);
    }

    @Override
    public int authRoles(Integer roleId, List<Long> permissionIds) {
        TabRoleVO tabRoleVO = tabRoleMapper.selectByPrimaryKey(roleId);
        if (tabRoleVO == null){
            throw new AppException(ReturnCode.ROLE_IS_NOT_EXIST, ReturnCode.ROLE_IS_NOT_EXIST_MSG);
        }

        //获取已经拥有的权限
        List<TabRolePermissionVO> addPermission = new ArrayList<>();
        List<TabPermissionVO> holdPermissions = tabPermissionMapper.selectPermissionByRoleId(roleId);
        Set<Long> holdSet = holdPermissions.stream().map(TabPermissionVO::getId).collect(Collectors.toSet());
        for (Long permissionId:permissionIds) {
            if (!holdSet.contains(permissionId)){
                TabRolePermissionVO tabRolePermissionVO = new TabRolePermissionVO();
                tabRolePermissionVO.setRoleId(roleId);
                tabRolePermissionVO.setPermissionId(permissionId);
                addPermission.add(tabRolePermissionVO);
            }
        }
        return tabRolePermissionMapper.beatchInsert(addPermission);
    }

    @Override
    public int canceAuthRole(Integer rolePermissionId) {
        return tabRolePermissionMapper.deleteByPrimaryKey(rolePermissionId);
    }

    @Override
    public int canceAuthRoles(Integer roleId, List<Long> permissionIds) {
        TabRoleVO tabRoleVO = tabRoleMapper.selectByPrimaryKey(roleId);
        if (tabRoleVO == null){
            throw new AppException(ReturnCode.ROLE_IS_NOT_EXIST, ReturnCode.ROLE_IS_NOT_EXIST_MSG);
        }
        for (Long permissionId:permissionIds) {
            tabRolePermissionMapper.deleteByRoleIdAndPermissionId(roleId, permissionId);
        }
        return 0;
    }

    @Override
    public List<TabPermissionVO> findRolePermissions(Integer roleId) {
        return tabPermissionMapper.selectPermissionByRoleId(roleId);
    }
}
