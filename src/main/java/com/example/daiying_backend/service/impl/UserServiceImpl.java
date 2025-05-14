package com.example.daiying_backend.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.config.JwtUtils;
import com.example.daiying_backend.config.ResultCode;
import com.example.daiying_backend.dao.mapper.UserMapper;
import com.example.daiying_backend.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.daiying_backend.pojo.User user = userMapper.getByName(username);
        // 假设数据库中查询到用户（示例硬编码）
        if (user!=null && user.getUsername().equals(username)) {
//
//            Collection<? extends GrantedAuthority> authorities = user.getRoles().stream()
//                    .map(role -> new SimpleGrantedAuthority(role.getName()))
//                    .collect(Collectors.toList());
            return User.builder()
                    .username(user.getUsername())
                    .password(passwordEncoder().encode(user.getPassword()))
                    .roles(user.getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException("用户不存在: " + username);
        }
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public CommonResult createUser(com.example.daiying_backend.pojo.User user) {
        com.example.daiying_backend.pojo.User user1 = userMapper.getByName(user.getUsername());
        com.example.daiying_backend.pojo.User user2 = userMapper.getUserByPhone(user.getPhone());
        if(user1!=null){
            return CommonResult.faild("用户名已存在！");
        }
        if(user2!=null){
            return CommonResult.faild("该手机号已被注册！");
        }
        user.setCreateTime(new Date());
        int userNum = userMapper.createUser(user);
        if(userNum==1){
            return CommonResult.success("注册成功！",null);
        }else{
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult login(String loginRequest) {
        JSONObject jsonObject = JSONUtil.parseObj(loginRequest);
        String username = jsonObject.getStr("username");
        String password = jsonObject.getStr("password");
        JwtUtils jwtUtils = new JwtUtils();
        com.example.daiying_backend.pojo.User userDetails = userMapper.getByName(username);
        if(userDetails==null){
            return new CommonResult(ResultCode.FAILD.getCode(),"用户名或密码错误！",null);
        }else{
            if(userDetails.getUsername().equals(username) && userDetails.getPassword().equals(password)){
                String token = jwtUtils.generateToken(userDetails);
                return CommonResult.success("登录成功！",token);
            }else{
                return new CommonResult(ResultCode.FAILD.getCode(),"用户名或密码错误！",null);
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
    public CommonResult getAllUser() {
        List<com.example.daiying_backend.pojo.User> allUser = userMapper.getAllUser();
        return CommonResult.success(allUser);
    }

    @Override
    public CommonResult updateUser(com.example.daiying_backend.pojo.User user) {
        int userNum = userMapper.updateUser(user);
        if(userNum==1){
            return CommonResult.success("修改成功！");
        }else{
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult deleteUserById(Integer id) {
        int userNum = userMapper.deleteUserById(id);
        if(userNum==1){
            return CommonResult.success("删除成功！");
        }else{
            return CommonResult.faild();
        }
    }

}
