package com.user.manager.service;

import com.user.common.PageInfo;
import com.user.manager.vo.TabRoleVO;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:    角色业务实现类
 */
public interface RoleService {

    /**
     * 添加新角色
     * @param name ：角色名字
     * @param type ：类型
     * @return
     */
    int addRole(String name, String type);

    /**
     * 删除角色
     * @param id ：角色id
     * @return
     */
    int delRole(Integer id);


    /**
     * 修改角色信息
     * @param id ：角色id
     * @param name :角色名字
     * @param type ：角色类型
     * @param available : 是否可用 0：不可用，1：可用
     * @return
     */
    TabRoleVO changeRole(Integer id, String name, String type, String available);

    /**
     * 根据id获取角色信息
     * @param id：角色id
     * @return
     */
    TabRoleVO findRole(Integer id);

    /**
     * 分页查询角色
     * @param name
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<List<TabRoleVO>> findRoles(String name, String type, String available, Integer pageNum, Integer pageSize);

    /**
     * 查看所有角色
     * @param available ：是否可用 0：不可用 1：可用 2：所有
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<List<TabRoleVO>> showRoles(String available, Integer pageNum, Integer pageSize);






}
