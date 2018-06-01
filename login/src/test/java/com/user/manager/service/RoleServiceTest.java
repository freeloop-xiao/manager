package com.user.manager.service;

import com.user.common.PageInfo;
import com.user.manager.vo.TabRoleVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:   角色业务测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;


    @Test
    public void addRole() {
        for (int i = 0; i < 20; i++) {
            int result = roleService.addRole("test" + i, "管理员" + i);
            Assert.assertEquals(1,result);
        }
    }

    @Test
    public void delRole() {
        Assert.assertEquals(1,roleService.delRole(1));
    }

    @Test
    public void changeRole() {
        TabRoleVO changeAll = roleService.changeRole(10, "修改名字1", "修改类型1", "0");
        //第一个对象测试
        Assert.assertEquals(10,changeAll.getId().intValue());
        Assert.assertEquals("修改名字1",changeAll.getName());
        Assert.assertEquals("修改类型1",changeAll.getType());
        Assert.assertEquals("0",changeAll.getAvailable());

        TabRoleVO changeNameAndType = roleService.changeRole(11, "修改名字", "修改类型", null);
        Assert.assertEquals(11,changeNameAndType.getId().intValue());
        Assert.assertEquals("修改名字",changeNameAndType.getName());
        Assert.assertEquals("修改类型",changeNameAndType.getType());
        Assert.assertEquals("1",changeNameAndType.getAvailable());

        TabRoleVO changeAvailable = roleService.changeRole(12, null, null, "0");
        Assert.assertEquals(12,changeAvailable.getId().intValue());
        Assert.assertEquals("0",changeAvailable.getAvailable());

        TabRoleVO changeType = roleService.changeRole(13, null, "只修改类型", null);
        Assert.assertEquals(13,changeType.getId().intValue());
        Assert.assertEquals("只修改类型",changeType.getType());

        TabRoleVO changeName = roleService.changeRole(14, "只修改名字", null, null);
        Assert.assertEquals(14,changeName.getId().intValue());
        Assert.assertEquals("只修改名字",changeName.getName());
    }

    @Test
    public void findRole(){
        TabRoleVO tabRoleVO = roleService.findRole(10);
        Assert.assertNotEquals(null,tabRoleVO);
    }

    @Test
    public void findRoles() {
        PageInfo<List<TabRoleVO>> data = roleService.findRoles("test1",null,null,null,null);
        Assert.assertEquals(1,data.getData().size());
        data = roleService.findRoles(null,"管理员2",null,null,null);
        Assert.assertEquals(1,data.getData().size());
        data = roleService.findRoles(null,null,"1",null,null);
        Assert.assertEquals(10,data.getData().size());
        data = roleService.findRoles("test1",null,"1",null,null);
        Assert.assertEquals(1,data.getData().size());
    }

    @Test
    public void showRoles() {
        PageInfo<List<TabRoleVO>> data = roleService.showRoles("1",1,5);
        Assert.assertEquals(5,data.getData().size());
        data = roleService.showRoles("0",1,5);
        Assert.assertEquals(2,data.getData().size());
        data = roleService.showRoles("2",1,5);
        Assert.assertEquals(5,data.getData().size());
    }
}