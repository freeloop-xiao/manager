package com.user.manager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.user.common.ManagerStatusEnum;
import com.user.common.PageInfo;
import com.user.manager.dao.TabRoleMapper;
import com.user.manager.service.RoleService;
import com.user.manager.vo.TabRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:    角色业务逻辑类
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private TabRoleMapper tabRoleMapper;

    @Override
    public int addRole(String name, String type) {
        TabRoleVO tabRoleVO = new TabRoleVO();
        tabRoleVO.setName(name);
        tabRoleVO.setType(type);
        return tabRoleMapper.insertSelective(tabRoleVO);
    }

    @Override
    public int delRole(Integer id) {
        return tabRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TabRoleVO changeRole(Integer id, String name, String type, String available) {
        TabRoleVO tabRoleVO = new TabRoleVO();
        tabRoleVO.setId(id);
        tabRoleVO.setName(name);
        tabRoleVO.setType(type);
        tabRoleVO.setAvailable(available);
        tabRoleMapper.updateByPrimaryKeySelective(tabRoleVO);
        return tabRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public TabRoleVO findRole(Integer id) {
        return tabRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<List<TabRoleVO>> findRoles(String name, String type, String available, Integer pageNum, Integer pageSize) {
        pageNum = PageInfo.checkPageNum(pageNum);
        pageSize = PageInfo.checkPageSize(pageSize);
        //条件
        TabRoleVO conditions = new TabRoleVO();
        conditions.setName(name);
        conditions.setType(type);
        if (ManagerStatusEnum.ALL.getValue().equals(available)){
            available = null;
        }
        conditions.setAvailable(available);
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<TabRoleVO> data = tabRoleMapper.selectBySelective(conditions);
        if (data == null || data.size() == 0){
            return null;
        }
        return new PageInfo<>(pageNum, pageSize, page.getTotal(), data);
    }

    @Override
    public PageInfo<List<TabRoleVO>> showRoles(String available, Integer pageNum, Integer pageSize) {
        if (ManagerStatusEnum.ALL.getValue().equals(available)){
            available = null;
        }
        pageNum = PageInfo.checkPageNum(pageNum);
        pageSize = PageInfo.checkPageSize(pageSize);
        TabRoleVO conditon = new TabRoleVO();
        conditon.setAvailable(available);
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<TabRoleVO> data = tabRoleMapper.selectByAvailable(conditon);
        if (data == null || data.size() == 0){
            return null;
        }
        return new PageInfo<>(pageNum, pageSize, page.getTotal(), data);
    }
}
