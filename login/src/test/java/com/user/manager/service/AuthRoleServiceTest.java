package com.user.manager.service;

import com.alibaba.fastjson.JSON;
import com.user.exception.AppException;
import com.user.manager.vo.RolePermissionVO;
import com.user.manager.vo.TabPermissionVO;
import com.user.manager.vo.TabRolePermissionVO;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * author: xiao
 * date:   2018/6/3
 * desc:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthRoleServiceTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Autowired
    private AuthRoleService authRoleService;

    @Test
    public void authRole() {
        int result = authRoleService.authRole(2, 2L);
        Assert.assertEquals(1, result);

    }

    @Test
    public void authRoleExceptedAppException(){
        thrown.expect(AppException.class);
        authRoleService.authRole(2, 2L);

        thrown.expect(AppException.class);
        authRoleService.authRole(100, 2L);

        thrown.expect(AppException.class);
        authRoleService.authRole(2, 100L);

    }


    @Test
    public void authRoles() {
        List<Long>  permissionIds = Arrays.asList(2L, 3L, 4L, 5L);
        int result = authRoleService.authRoles(4, permissionIds);
        Assert.assertEquals(4, result);
    }

    @Test
    public void authRolesExpectedAppException(){
        thrown.expect(AppException.class);
        int result = authRoleService.authRoles(100,Arrays.asList(3L));

    }


    @Test
    public void canceAuthRole() {
        authRoleService.canceAuthRole(3);
    }

    @Test
    public void canceAuthRoles() {
        int result = authRoleService.canceAuthRoles(4,Arrays.asList(4, 5));
        Assert.assertEquals(2, result);
    }

    @Test
    public void canceAuthRolesExpectedAppException() {
        thrown.expect(AppException.class);
        int result = authRoleService.canceAuthRoles(100,Arrays.asList(4, 5));
    }

    @Test
    public void findRolePermissions() {
        List<RolePermissionVO> list = authRoleService.findRolePermissions(4);
        for (RolePermissionVO r:list){
            System.out.println(r);
        }
        Assert.assertEquals(3, list.size());
    }
}