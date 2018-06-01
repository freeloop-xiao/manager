package com.user.manager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.user.common.PageInfo;
import com.user.manager.dao.TabPermissionMapper;
import com.user.manager.service.PermissionService;
import com.user.manager.util.ManagerConstants;
import com.user.manager.vo.TabPermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: xiao
 * date:   2018/5/30
 * desc:   添加权限业务逻辑实现类
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private TabPermissionMapper tabPermissionMapper;

    @Override
    public TabPermissionVO addPermission(String name, String type, String url, String appName) {
        TabPermissionVO permission = new TabPermissionVO();
        permission.setName(name);
        permission.setType(type);
        permission.setUrl(url);
        permission.setAppName(appName);
        permission.setAvailable(ManagerConstants.AVAILABLE_STATUS);
        tabPermissionMapper.insert(permission);
        permission = tabPermissionMapper.selectByTypeAndUrl(type,url);
        return permission;
    }

    @Override
    public int delPermission(Long id) {
        return tabPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int changePermission(Long id, String name, String type, String url, String appName, String available) {
        TabPermissionVO permission = new TabPermissionVO();
        permission.setId(id);
        permission.setName(name);
        permission.setType(type);
        permission.setAvailable(available);
        permission.setUrl(url);
        permission.setAppName(appName);
        return tabPermissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public TabPermissionVO findPermission(Long id){
        return tabPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<List<TabPermissionVO>> findPermissions(Long id, String name, String type, String url, String appName, String available, Integer pageNum, Integer pageSize) {
        TabPermissionVO permission = new TabPermissionVO();
        permission.setId(id);
        permission.setName(name);
        permission.setType(type);
        permission.setUrl(url);
        permission.setAppName(appName);
        permission.setAvailable(available);
        if (pageNum == null || pageNum == 0){
            pageNum = 1;
        }
       if (pageSize == null || pageSize == 0){
           pageSize = 10;
       }
        Page<?> page = PageHelper.startPage(pageNum,pageSize);
        List<TabPermissionVO> data = tabPermissionMapper.selectBySelective(permission);
        return new PageInfo(pageNum, pageSize, page.getTotal(), data);
    }

    @Override
    public PageInfo<List<TabPermissionVO>> showPermissions(String availabe, Integer pageNum, Integer pageSize) {
        Page<?> page = PageHelper.startPage(pageNum, pageSize);
        List<TabPermissionVO> data = tabPermissionMapper.selectByAvilable(availabe);
        return new PageInfo(pageNum, pageSize, page.getTotal(), data);
    }
}
