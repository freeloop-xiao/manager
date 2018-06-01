package com.user.manager.service;

import com.user.common.PageInfo;
import com.user.manager.vo.TabAdminVO;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:  后台用户管理接口
 */
public interface AdminService {


    int addAdmin(String name, String email, String phoneNo, String pwd, Integer userLevel, String appId, String remark);


    int delAdmin(String id);

    TabAdminVO changeAdmin(String id,String name, String email, String phoneNo, Integer userLevel, String appId, String remark, String available);

    TabAdminVO findAdmin(String id);

    PageInfo<List<TabAdminVO>> findAdmins(String name, String email, String phoneNo, Integer userLevel, String available, String appId, Integer pageNum, Integer pageSize);

    PageInfo<List<TabAdminVO>> showAdmins(String available, Integer pageNum, Integer pageSize);
}
