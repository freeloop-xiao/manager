package com.user.manager.service;

import com.user.common.EncryptUtils;
import com.user.common.PageInfo;
import com.user.common.RandomUtils;
import com.user.manager.vo.TabAdminVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * author: xiao
 * date:   2018/6/1
 * desc:    用户管理业务测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void addAdmin() {
        for (int i = 0; i < 20; i++) {
            TabAdminVO tabAdminVO = new TabAdminVO();
            tabAdminVO.setAppId("appid");
            tabAdminVO.setUserLevel(1);
            tabAdminVO.setPhoneNo("18229196961" + i);
            tabAdminVO.setEmail("306923140@qq.com" + i);
            tabAdminVO.setName("测试" + i);
            tabAdminVO.setPwd("123456");
            tabAdminVO.setCreateDate(new Date());
            tabAdminVO.setRemark("测试");
            int result = adminService.addAdmin(tabAdminVO.getName(), tabAdminVO.getEmail(), tabAdminVO.getPhoneNo(), tabAdminVO.getPwd(),tabAdminVO.getUserLevel(), tabAdminVO.getAppId(),tabAdminVO.getRemark());
            Assert.assertEquals(1,result);
        }
    }

    @Test
    public void delAdmin() {
        int result = adminService.delAdmin("0364818432");
        Assert.assertEquals(1, result);
    }

    @Test
    public void changeAdmin() {
        TabAdminVO tabAdminVO = adminService.changeAdmin("1069461504", "hello", "email", "phoneNo", 2,"应用id", "备注","0");
        Assert.assertEquals("1069461504", tabAdminVO.getId());
        Assert.assertEquals("hello", tabAdminVO.getName());
        Assert.assertEquals("email", tabAdminVO.getEmail());
        Assert.assertEquals("phoneNo", tabAdminVO.getPhoneNo());
        Assert.assertEquals("应用id", tabAdminVO.getAppId());
        Assert.assertEquals("备注", tabAdminVO.getRemark());
        Assert.assertEquals("0", tabAdminVO.getAvailable());
    }

    @Test
    public void findAdmin() {
        TabAdminVO tabAdminVO = adminService.findAdmin("1069461504");
        Assert.assertNotEquals(null, tabAdminVO);
    }

    @Test
    public void findAdmins() {
        PageInfo<List<TabAdminVO>> pageInfo = adminService.findAdmins("测试1", "306923140@qq.com1","182291969611",1,"1","appid",1,5);
        Assert.assertEquals(1, pageInfo.getData().size());
        pageInfo = adminService.findAdmins("测试2", "306923140@qq.com2",null,null,"1","appid",1,5);
        Assert.assertEquals(1, pageInfo.getData().size());
    }

    @Test
    public void showAdmins() {
        PageInfo<List<TabAdminVO>> pageInfo = adminService.showAdmins("1",1,5);
        Assert.assertEquals(5, pageInfo.getData().size());
        pageInfo = adminService.showAdmins("0",1,5);
        Assert.assertEquals(0, pageInfo.getData().size());
        pageInfo = adminService.showAdmins("2",1,5);
        Assert.assertEquals(5, pageInfo.getData().size());
    }

}