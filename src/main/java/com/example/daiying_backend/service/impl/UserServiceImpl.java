package com.example.daiying_backend.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.config.JwtUtils;
import com.example.daiying_backend.config.ResultCode;
import com.example.daiying_backend.dao.mapper.UserMapper;
import com.example.daiying_backend.pojo.User;
import com.example.daiying_backend.pojo.UserDetailsPojo;
import com.example.daiying_backend.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.daiying_backend.pojo.User user = userMapper.getByName(username);
        if (user != null && user.getUsername().equals(username)) {
            return new UserDetailsPojo(user);
        } else {
            throw new UsernameNotFoundException("用户不存在: " + username);
        }
    }


    @Override
    public CommonResult createUser(com.example.daiying_backend.pojo.User user) {
        try {
            com.example.daiying_backend.pojo.User user1 = userMapper.getByName(user.getUsername());
            com.example.daiying_backend.pojo.User user2 = userMapper.getUserByPhone(user.getPhone());
            if (user1 != null) {
                return CommonResult.faild("用户名已存在！");
            }
            if (user2 != null) {
                return CommonResult.faild("该手机号已被注册！");
            }
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setCreateTime(new Date());
            userMapper.createUser(user);
            return CommonResult.success("注册成功！", null);
        } catch (Exception e) {
            return CommonResult.faild("服务器内部错误！");
        }
    }

    @Override
    public CommonResult login(String loginRequest) {
        JSONObject jsonObject = JSONUtil.parseObj(loginRequest);
        String username = jsonObject.getStr("username");
        String password = jsonObject.getStr("password");
        JwtUtils jwtUtils = new JwtUtils();
        com.example.daiying_backend.pojo.User user = userMapper.getByName(username);
        if (user == null) {
            return new CommonResult(ResultCode.FAILD.getCode(), "用户名或密码错误！", null);
        } else {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String token = jwtUtils.generateToken(userDetails);
                Map<String, String> tokenMap = new HashMap<>();
                tokenMap.put("token", token);
                tokenMap.put("userId", user.getId().toString());
                tokenMap.put("userName", user.getUsername());
                return CommonResult.success("登录成功！", tokenMap);
            } catch (Exception e) {
                return new CommonResult(ResultCode.FAILD.getCode(), "用户名或密码错误！", null);
            }
        }
    }

    @Override
    public CommonResult getById(Integer id) {
        com.example.daiying_backend.pojo.User user = userMapper.getById(id);
        return CommonResult.success(user);
    }

    @Override
    public CommonResult getByName(String username) {
        com.example.daiying_backend.pojo.User user = userMapper.getByName(username);
        return CommonResult.success(user);
    }

    @Override
    public CommonResult getAllUser(String username, String phone) {
        List<com.example.daiying_backend.pojo.User> allUser = userMapper.getAllUser(username, phone);
        return CommonResult.success(allUser);
    }

    @Override
    public CommonResult getAllUserByRole(String role) {
        try {
            List<User> allUserByRole = userMapper.getAllUserByRole(role);
            return CommonResult.success(allUserByRole);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult updateUser(com.example.daiying_backend.pojo.User user) {
        try {
            User byId = userMapper.getById(user.getId());
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            byId.setUsername(user.getUsername());
            byId.setPassword(encodedPassword);
            byId.setEmail(user.getEmail());
            byId.setPhone(user.getPhone());
            if (user.getRole() != null) {
                byId.setRole(user.getRole());
            }
            userMapper.updateUser(byId);
            return CommonResult.success("修改成功！");
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult deleteUserById(Integer id) {
        int userNum = userMapper.deleteUserById(id);
        if (userNum == 1) {
            return CommonResult.success("删除成功！");
        } else {
            return CommonResult.faild();
        }
    }

}
