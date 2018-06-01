package com.user.manager.dao;

import com.user.manager.vo.TabAdminRoleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TabAdminRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabAdminRoleVO record);

    int insertSelective(TabAdminRoleVO record);

    TabAdminRoleVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TabAdminRoleVO record);

    int updateByPrimaryKey(TabAdminRoleVO record);
}