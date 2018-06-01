package com.user.manager.service;

import com.alibaba.fastjson.JSON;
import com.user.manager.vo.TabPermissionVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: xiao
 * date:   2018/5/31
 * desc:    权限业务测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void addPermission() {
        for (int i = 20; i < 20; i++) {
            TabPermissionVO permissionVO = permissionService.addPermission("百度" + i, "resouce" + i, "http://www.baidu.com" + i, "业务系统");
            System.out.println("添加权限：" + JSON.toJSONString(permissionVO));
        }
    }

    @Test
    public void delPermission() {
        Assert.assertEquals(1,permissionService.delPermission(18L));
    }

    @Test
    public void changePermission() {
        Assert.assertEquals(1,permissionService.changePermission(2L,"腾讯", "resource100", "qq.com2","应用系统","1"));
        Assert.assertEquals(1,permissionService.changePermission(3L,"腾讯", "resource100", "qq.com3",null,null));
        Assert.assertEquals(1,permissionService.changePermission(4L,"腾讯", "resource100", null,null,null));
        Assert.assertEquals(1,permissionService.changePermission(5L,"腾讯", null, null,null,null));
        Assert.assertEquals(1,permissionService.changePermission(6L, null, null, null,null,"0"));
    }

    @Test
    public void findPermission() {
        System.out.println("分页查找");
        System.out.println(JSON.toJSONString(permissionService.findPermissions(null, null, null, null, "1",null, 1, 5)));

    }

    @Test
    public void showPermissions() {
        System.out.println(JSON.toJSONString(permissionService.showPermissions("1", 1, 5)));
    }
}