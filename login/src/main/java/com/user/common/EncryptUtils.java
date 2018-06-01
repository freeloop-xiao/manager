package com.user.common;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:    密码加密工具类
 */
public class EncryptUtils {

    /**
     * 对密码进行sha512+salt加密
     * @param data：数据
     * @param salt：盐
     * @return
     */
    public static String encryptSHA512(String data,String salt){
        return new SimpleHash(Constants.PASSWORD_ALGORITHM, data, ByteSource.Util.bytes(salt), 1).toHex();
    }
}
