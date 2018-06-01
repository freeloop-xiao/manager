package com.user.manager.dao;

import com.user.manager.vo.TabAdminVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TabAdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(TabAdminVO record);

    int insertSelective(TabAdminVO record);

    TabAdminVO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TabAdminVO record);

    int updateByPrimaryKey(TabAdminVO record);
}