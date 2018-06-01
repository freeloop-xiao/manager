package com.user.register.dao;

import com.user.register.vo.TabAppVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TabAppMapper {

    int deleteByPrimaryKey(@Param("appId") String appId);

    int insert(TabAppVO record);

    int insertSelective(TabAppVO record);

    TabAppVO selectByPrimaryKey(String appId);

    int updateByPrimaryKeySelective(TabAppVO record);

    int updateByPrimaryKey(TabAppVO record);
}