package com.user.common;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:
 */
public class RandomUtilsTest {
    @Test
    public void generateSaltTest(){
        System.out.println(RandomUtils.generateSalt(16));
        System.out.println(RandomUtils.generateSalt(16));
        System.out.println(RandomUtils.generateSalt(16));
        System.out.println(RandomUtils.generateSalt(16));
    }

    @Test
    public void generateSaltsTest() throws Exception{
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        System.out.println(salt);
        String newPassword = new SimpleHash(
                Constants.PASSWORD_ALGORITHM,           //加密算法
                "xiaokun",      //密码
                ByteSource.Util.bytes(salt),  //salt盐   username + salt
                1   //迭代次数
        ).toHex();
        System.out.println("password:"+newPassword.length());
        newPassword = new SimpleHash(
                "SHA-512",           //加密算法
                "xioakunasdfasdf",      //密码
                ByteSource.Util.bytes(salt),  //salt盐   username + salt
                1   //迭代次数
        ).toHex();
        System.out.println("password:"+newPassword.length());
        newPassword = new SimpleHash(
                "SHA-512",           //加密算法
                "xiasafasfweokun",      //密码
                ByteSource.Util.bytes(salt),  //salt盐   username + salt
                1   //迭代次数
        ).toHex();
        System.out.println("password:"+newPassword.length());
        newPassword = new SimpleHash(
                "SHA-512",           //加密算法
                "xiagdsfgseokun",      //密码
                ByteSource.Util.bytes(salt),  //salt盐   username + salt
                1   //迭代次数
        ).toHex();
        System.out.println("password:"+newPassword);
    }

}