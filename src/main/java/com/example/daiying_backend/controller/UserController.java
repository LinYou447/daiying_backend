package com.example.daiying_backend.controller;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.User;
import com.example.daiying_backend.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value("${jwt.fix}")
    private String fix;

    @Autowired
    UserService userService;

    public UserController() {
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/regedit")
    public CommonResult regedit(@RequestBody User user){
        CommonResult commonResult = userService.createUser(user);
        return commonResult;
    }

    @PostMapping("/login")
    public CommonResult login(@RequestBody String requestBody){
        return userService.login(requestBody);
    }
}
