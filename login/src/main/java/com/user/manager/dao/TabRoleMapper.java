package com.user.manager.dao;

import com.user.manager.vo.TabRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TabRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabRoleVO record);

    int insertSelective(TabRoleVO record);

    TabRoleVO selectByPrimaryKey(Integer id);

    List<TabRoleVO> selectBySelective(TabRoleVO tabRoleVO);

    List<TabRoleVO> selectByAvailable(TabRoleVO tabRoleVO);

    Integer findRoleCount(@Param("list") List<Integer> list);

    int updateByPrimaryKeySelective(TabRoleVO record);

    int updateByPrimaryKey(TabRoleVO record);
}