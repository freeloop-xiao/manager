package com.user.manager.dao;

import com.user.manager.vo.TabAdminVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TabAdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(TabAdminVO record);

    int insertSelective(TabAdminVO record);

    TabAdminVO selectByPrimaryKey(String id);

    TabAdminVO selectUsualByPrimaryKey(String id);

    List<TabAdminVO> selectBySelective(TabAdminVO record);

    List<TabAdminVO> selectByAvailable(@Param("available") String available);

    TabAdminVO selectByPhoneNo(@Param("phoneNo") String phoneNo);

    int updateByPrimaryKeySelective(TabAdminVO record);

    int updateByPrimaryKey(TabAdminVO record);
}