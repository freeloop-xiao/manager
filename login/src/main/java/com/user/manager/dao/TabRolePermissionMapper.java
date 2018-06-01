package com.user.manager.dao;

import com.user.manager.vo.TabRolePermissionVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TabRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabRolePermissionVO record);

    int insertSelective(TabRolePermissionVO record);

    TabRolePermissionVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TabRolePermissionVO record);

    int updateByPrimaryKey(TabRolePermissionVO record);
}