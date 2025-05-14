package com.example.daiying_backend.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptExample {

    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String passwordEncryption(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // 强度因子（4~31）
        String encodedPassword = encoder.encode(password); // 加密
        return encodedPassword;
    }

    /**
     * 验证密码是否正确
     * @param passwordStr 用户登录的密码
     * @return
     */
    public static Boolean passwordVerify(String passwordStr){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // 强度因子（4~31）
        String encodedPassword = encoder.encode(passwordStr); // 加密

        boolean isMatch = encoder.matches(passwordStr, encodedPassword); // 验证
        return isMatch;
    }
}
