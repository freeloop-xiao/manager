package com.user.manager.service.impl;

import com.user.common.ReturnCode;
import com.user.exception.AppException;
import com.user.manager.dao.TabAdminMapper;
import com.user.manager.dao.TabAdminRoleMapper;
import com.user.manager.dao.TabRoleMapper;
import com.user.manager.service.AuthAdminService;
import com.user.manager.vo.TabAdminRoleVO;
import com.user.manager.vo.TabAdminVO;
import com.user.manager.vo.TabRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: xiao
 * date:   2018/6/4
 * desc:    用户授权角色业务类
 */
@Service
public class AuthAdminServiceImpl implements AuthAdminService {

    @Autowired
    private TabAdminRoleMapper tabAdminRoleMapper;

    @Autowired
    private TabRoleMapper tabRoleMapper;

    @Autowired
    private TabAdminMapper tabAdminMapper;

    @Override
    public int authRole(String adminId, Integer roleId) {
        TabAdminVO tabAdminVO = tabAdminMapper.selectUsualByPrimaryKey(adminId);

        if (tabAdminVO == null){
            throw new AppException(ReturnCode.APP_IS_NOT_EXIT, ReturnCode.APP_IS_NOT_EXIT_MSG);
        }

        TabRoleVO roleVO = tabRoleMapper.selectByPrimaryKey(roleId);

        if (roleVO == null){
            throw new AppException(ReturnCode.ROLE_IS_NOT_EXIST_MSG, ReturnCode.ROLE_IS_NOT_EXIST_MSG);
        }

        TabAdminRoleVO tabAdminRoleVO = new TabAdminRoleVO();
        tabAdminRoleVO.setAdminId(adminId);
        tabAdminRoleVO.setRoleId(roleId);

        return tabAdminRoleMapper.insertSelective(tabAdminRoleVO);
    }

    @Override
    public int authRoles(String adminId, List<Integer> roleIds) {

        if (roleIds == null || roleIds.isEmpty()){
            throw new AppException(ReturnCode.PARAM_NO_SEND,ReturnCode.PARAM_NO_SEND_MSG);
        }

        TabAdminVO tabAdminVO = tabAdminMapper.selectUsualByPrimaryKey(adminId);
        if (tabAdminVO == null){
            throw new AppException(ReturnCode.APP_IS_NOT_EXIT, ReturnCode.APP_IS_NOT_EXIT_MSG);
        }
        // 查询是否存在角色
        Integer count = tabRoleMapper.findRoleCount(roleIds);
        if (count != roleIds.size()){
            throw new AppException(ReturnCode.ROLE_IS_NOT_EXIST, ReturnCode.ROLE_IS_NOT_EXIST_MSG);
        }

        count = tabAdminRoleMapper.selectRoleCount(adminId, roleIds);
        if (count > 0){
            throw new AppException(ReturnCode.ROLE_IS_EXIST, ReturnCode.ROLE_IS_NOT_EXIST_MSG);
        }

        List<TabAdminRoleVO> datas = new ArrayList<>();

        for (Integer roleId:roleIds) {
            TabAdminRoleVO tabAdminRoleVO = new TabAdminRoleVO();

            tabAdminRoleVO.setAdminId(adminId);
            tabAdminRoleVO.setRoleId(roleId);
            datas.add(tabAdminRoleVO);
        }

        return tabAdminRoleMapper.insertByBatch(datas);
    }

    @Override
    public int canceRole(Integer adminRoleId) {
        return tabAdminRoleMapper.deleteByPrimaryKey(adminRoleId);
    }


    @Override
    public int canceRoles(List<Integer> adminRoleIds) {
        return tabAdminRoleMapper.batchDelete(adminRoleIds);
    }
}
