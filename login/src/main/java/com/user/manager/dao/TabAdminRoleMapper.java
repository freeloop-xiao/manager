package com.user.manager.dao;

import com.user.manager.vo.TabAdminRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

@Mapper
public interface TabAdminRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int batchDelete(List<Integer> list);

    int insert(TabAdminRoleVO record);

    int insertSelective(TabAdminRoleVO record);

    int insertByBatch(List<TabAdminRoleVO> list);

    TabAdminRoleVO selectByPrimaryKey(Integer id);

    Integer selectRoleCount(@Param("adminId") String adminId,@Param("list") List<Integer> list);

    int updateByPrimaryKeySelective(TabAdminRoleVO record);

    int updateByPrimaryKey(TabAdminRoleVO record);
}