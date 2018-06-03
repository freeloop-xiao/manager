package com.user.manager.dao;

import com.user.manager.vo.RolePermissionVO;
import com.user.manager.vo.TabRolePermissionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sun.rmi.runtime.Log;

import java.util.List;

@Mapper
public interface TabRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByRoleIdAndPermissionId(@Param("roleId") Integer roleId, @Param("permissionId") Long permissionId);

    int beatchDelete(List<Integer> list);

    int insert(TabRolePermissionVO record);

    int insertSelective(TabRolePermissionVO record);

    int beatchInsert(List<TabRolePermissionVO> records);

    TabRolePermissionVO selectByPrimaryKey(Integer id);

    TabRolePermissionVO selectByRoleIdAndPermissionId(@Param("roleId") Integer roleId, @Param("permissionId") Long permissionId);

    List<RolePermissionVO> selectRolePermissions(@Param("roleId") Integer roleId);

    List<TabRolePermissionVO> selectByRoleId(@Param("roleId") Integer roleId);

    int updateByPrimaryKeySelective(TabRolePermissionVO record);

    int updateByPrimaryKey(TabRolePermissionVO record);
}