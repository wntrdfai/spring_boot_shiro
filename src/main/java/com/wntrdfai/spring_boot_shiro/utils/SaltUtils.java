package com.wntrdfai.spring_boot_shiro.utils;

import java.util.Random;

/**
 * @author wntrdfai
 * @Packagecom.wntrdfai.springbootshiro.utils
 * @date 2021/8/13 9:05
 * 作用:
 */public class SaltUtils {
    /**
     * 生成salt的静态方法
     * @param n
     * @return
     */
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}