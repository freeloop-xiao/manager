package com.user.manager.dao;

import com.user.manager.vo.TabPermissionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TabPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TabPermissionVO record);

    int insertSelective(TabPermissionVO record);

    TabPermissionVO selectByPrimaryKey(Long id);

    TabPermissionVO selectByTypeAndUrl(@Param("type") String type, @Param("url") String url);

    List<TabPermissionVO> selectBySelective(TabPermissionVO record);

    List<TabPermissionVO> selectByAvilable(@Param("available") String available);

    int updateByPrimaryKeySelective(TabPermissionVO record);

    int updateByPrimaryKey(TabPermissionVO record);
}