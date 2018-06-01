package com.user.common;

import java.util.Random;

/**
 * author: xiao
 * date:   2018/5/27
 * desc:   随机数产生器
 */
public class RandomUtils {

    public static IdGenerator IG = new IdGenerator(1023);
    /**
     * 生产六位数字的盐
     * @param length:长度
     * @return
     */
    public static String generateSalt(int length){
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /**
     * 生成数字最长18位
     * @param length
     * @return
     */
    public static String generateNumber(int length){
        long ids = IG.nextId();
        return String.valueOf(ids).substring(18-length);
    }
}
