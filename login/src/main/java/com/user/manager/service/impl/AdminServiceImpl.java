package com.user.manager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.user.common.*;
import com.user.exception.AppException;
import com.user.manager.dao.TabAdminMapper;
import com.user.manager.service.AdminService;
import com.user.manager.vo.TabAdminVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:    管理员管理实现类
 */
@Service
public class AdminServiceImpl implements AdminService{
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);


    @Autowired
    private TabAdminMapper tabAdminMapper;

    @Override
    public int addAdmin(String name, String email, String phoneNo, String pwd, Integer userLevel, String appId, String remark) {
        TabAdminVO tabAdminVO = tabAdminMapper.selectByPhoneNo(phoneNo);
        if (tabAdminVO != null){
            LOGGER.info("手机号为{}已经注册!", phoneNo);
            throw new AppException(ReturnCode.USER_HAS_REGISTED, ReturnCode.APP_IS_NOT_EXIT_MSG);
        }
        tabAdminVO = new TabAdminVO();
        tabAdminVO.setName(name);
        tabAdminVO.setEmail(email);
        tabAdminVO.setPhoneNo(phoneNo);
        String salt = RandomUtils.generateSalt(16);
        tabAdminVO.setPwd(EncryptUtils.encryptSHA512(pwd,salt));
        tabAdminVO.setSalt(salt);
        tabAdminVO.setUserLevel(userLevel);
        tabAdminVO.setCreateDate(new Date());
        tabAdminVO.setAppId(appId);
        tabAdminVO.setRemark(remark);
        tabAdminVO.setId(IdGenerator.generateId(8));
        return tabAdminMapper.insertSelective(tabAdminVO);
    }

    @Override
    public int delAdmin(String id) {
        return tabAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TabAdminVO changeAdmin(String id,String name, String email, String phoneNo, Integer userLevel, String appId, String remark, String available) {
        TabAdminVO tabAdminVO = tabAdminMapper.selectByPrimaryKey(id);
        if (tabAdminVO == null){
            LOGGER.info("用户{}信息不存在!", phoneNo);
            throw new AppException(ReturnCode.APP_IS_NOT_EXIT, ReturnCode.APP_IS_NOT_EXIT_MSG);
        }
        //用户等级1：普通管理员 2：超级管理员
        if (userLevel != null && userLevel != 1 && userLevel != 2){
            throw new AppException(ReturnCode.USER_LEVEL_ERROR,ReturnCode.PARAM_ERROR);
        }
        tabAdminVO = new TabAdminVO();
        tabAdminVO.setId(id);
        tabAdminVO.setName(name);
        tabAdminVO.setEmail(email);
        tabAdminVO.setPhoneNo(phoneNo);
        tabAdminVO.setUserLevel(userLevel);
        tabAdminVO.setAppId(appId);
        tabAdminVO.setRemark(remark);
        tabAdminVO.setAvailable(available);
        tabAdminMapper.updateByPrimaryKeySelective(tabAdminVO);
        tabAdminVO = tabAdminMapper.selectUsualByPrimaryKey(id);
        return tabAdminVO;
    }

    @Override
    public TabAdminVO findAdmin(String id) {
        return tabAdminMapper.selectUsualByPrimaryKey(id);
    }


    @Override
    public PageInfo<List<TabAdminVO>> findAdmins(String name, String email, String phoneNo, Integer userLevel, String available, String appId, Integer pageNum, Integer pageSize) {
        pageNum = PageInfo.checkPageNum(pageNum);
        pageSize = PageInfo.checkPageSize(pageSize);
        TabAdminVO tabAdminVO = new TabAdminVO();
        tabAdminVO.setName(name);
        tabAdminVO.setEmail(email);
        tabAdminVO.setPhoneNo(phoneNo);
        tabAdminVO.setUserLevel(userLevel);
        tabAdminVO.setAvailable(available);
        tabAdminVO.setAppId(appId);
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<TabAdminVO> data = tabAdminMapper.selectBySelective(tabAdminVO);
        return new PageInfo<>(pageNum, pageSize, page.getTotal(), data);
    }

    @Override
    public PageInfo<List<TabAdminVO>> showAdmins(String available, Integer pageNum, Integer pageSize) {
        if (ManagerStatusEnum.ALL.getValue().equals(available)){
            available = null;
        }
        pageNum = PageInfo.checkPageNum(pageNum);
        pageSize = PageInfo.checkPageSize(pageSize);
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<TabAdminVO> data = tabAdminMapper.selectByAvailable(available);
        return new PageInfo<>(pageNum, pageSize, page.getTotal(), data);
    }
}
