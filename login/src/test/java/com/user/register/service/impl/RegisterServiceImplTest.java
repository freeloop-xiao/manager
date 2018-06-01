package com.user.register.service.impl;

import com.user.register.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceImplTest {

    @Autowired
    private RegisterService registerService;

    @Test
    public void registerTest(){
        registerService.userRegister("1","18229196962","肖昆","xiaokun",1,"430321199307104111","306934150@qq.com","1","1","1");
    }
}