package com.user.manager.service;

import com.user.exception.AppException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: xiao
 * date:   2018/6/4
 * desc:    用户授权角色测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthAdminServiceTest {
    @Autowired
    private AuthAdminService authAdminService;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void authRole() {
        int result = authAdminService.authRole("1069461504", 2);
        Assert.assertEquals(1,result);

        thrown.expect(AppException.class);
        authAdminService.authRole("106946150411", 2);

        thrown.expect(AppException.class);
        authAdminService.authRole("1069461504", 100);
    }


    @Test
    public void authRoles() {
        List<Integer> roids = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
        int result = authAdminService.authRoles("1069461504", roids);
        Assert.assertEquals(8, result);
        roids = Arrays.asList(10,11,100);
        thrown.expect(AppException.class);
        authAdminService.authRoles("1069461504", roids);
    }

    @Test
    public void canceRole() {
        int result = authAdminService.canceRole(1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void canceRoles() {
        List<Integer> adminRoleIds = Arrays.asList(2, 3, 4, 5);
        int result = authAdminService.canceRoles(adminRoleIds);
        Assert.assertEquals(4, result);
    }
}