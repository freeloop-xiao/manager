package com.user.register.dao;

import com.user.register.vo.TabUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TabUserMapper {
    int deleteByPrimaryKey(String userNo);

    int insert(TabUserVO record);

    int insertSelective(TabUserVO record);

    TabUserVO selectByPrimaryKey(String userNo);

    TabUserVO selectByPhoneNoAndAppId(@Param("phoneNo") String phoneNo,@Param("appId") String appId);

    int updateByPrimaryKeySelective(TabUserVO record);

    int updateByPrimaryKey(TabUserVO record);
}