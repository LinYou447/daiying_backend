package com.example.daiying_backend.service.api;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    CommonResult createUser(User user);

    CommonResult login(String loginRequest);

    CommonResult getById(Integer id);

    CommonResult getByName(String username);

    CommonResult getAllUser(String username, String phone);

    CommonResult getAllUserByRole(String role);

    CommonResult updateUser(User user);

    CommonResult deleteUserById(Integer id);
}
