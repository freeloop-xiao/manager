package com.user.manager.dao;

import com.user.manager.vo.TabRoleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TabRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabRoleVO record);

    int insertSelective(TabRoleVO record);

    TabRoleVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TabRoleVO record);

    int updateByPrimaryKey(TabRoleVO record);
}