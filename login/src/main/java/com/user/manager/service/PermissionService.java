package com.user.manager.service;

import com.user.common.PageInfo;
import com.user.manager.vo.TabPermissionVO;

import java.util.List;

/**
 * author: xiao
 * date:   2018/5/30
 * desc:    权限管理接口
 */
public interface PermissionService {
    /**
     * 添加权限
     * @param name：权限名字
     * @param type：类型
     * @param url：url
     * @param appName :应用名称
     * @return
     */
    TabPermissionVO addPermission(String name, String type, String url, String appName);

    /**
     * 删除权限
     * @param id：删除权限
     * @return
     */
    int delPermission(Long id);

    /**
     * 修改权限信息
     * @param id：权限id
     * @param name:权限名字
     * @param type：类型
     * @param url：请求资源
     * @param appName :应用名称
     * @param available：是否可用0：不可用 1：可用
     * @return
     */
    int changePermission(Long id, String name, String type, String url, String appName ,String available);

    /**
     * 根据id查询权限信息
     * @param id：权限id
     * @return
     */
    TabPermissionVO findPermission(Long id);


    /**
     * 查找权限
     * @param id：权限id
     * @param name:权限名字
     * @param type：类型
     * @param url：请求资源
     * @param available：是否可用0：不可用 1：可用
     * @return
     */
    public PageInfo<List<TabPermissionVO>> findPermissions(Long id, String name, String type, String url, String appName, String available, Integer pageNum, Integer pageSize);

    /**
     * 获取权限
     * @param availabe:0:不可用 1：正常 2：所有
     * @param pageNum : 页码
     * @param pageSize ： 记录条数
     * @return
     */
    PageInfo<List<TabPermissionVO>> showPermissions(String availabe, Integer pageNum, Integer pageSize);
}
