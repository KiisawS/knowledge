package com.knowledge.leetcode;

import java.util.regex.Pattern;

/***
 * @ClassName Solution420
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/7/13 9:26
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class Solution420 {
    public static void main(String []args) {

        System.out.println("abA".matches("[a-z]+"));
//        System.out.println(strongPasswordChecker("aaA1aa"));
    }

    private static int strongPasswordChecker(String s) {
        if (!s.matches("^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{6,20}$")) {
            throw new IllegalArgumentException("密码不合法");
        }
        if (s.length() < 6 || s.length() > 20) {
            throw new IllegalArgumentException("密码由至少6个，至多20个字符组成");
        }
        if (!s.matches("[a-z]+") || !s.matches("[A-Z]+") || !s.matches("[0-9]+")) {
            throw new IllegalArgumentException("密码至少一个小写字母，一个大写字母，一个数字");
        }
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i+1) && s.charAt(i) == s.charAt(i+2)) {
                throw new IllegalArgumentException("同一个字符出现三次");
            }
        }
        return 0;
    }
}
