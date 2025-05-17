package com.example.daiying_backend.controller;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Search;
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

    @GetMapping("/userInfo")
    public CommonResult getUser(@RequestParam String username){
        CommonResult byName = userService.getByName(username);
        return byName;
    }

    @GetMapping("/getById")
    public CommonResult getById(@RequestParam Integer id){
        CommonResult byName = userService.getById(id);
        return byName;
    }

    @PostMapping("/editUser")
    public CommonResult editUser(@RequestBody User user){
        CommonResult byName = userService.updateUser(user);
        return byName;
    }

    @PostMapping("/getAll")
    public CommonResult getAll(@RequestBody Search search){
        CommonResult byName = userService.getAllUser(search.getUsername(),search.getPhone());
        return byName;
    }

    @GetMapping("/getAllByRole")
    public CommonResult getAllByRole(@RequestParam String role){
        CommonResult byName = userService.getAllUserByRole(role);
        return byName;
    }

    @DeleteMapping("/deleteById")
    public CommonResult deleteById(@RequestParam Integer id){
        CommonResult byName = userService.deleteUserById(id);
        return byName;
    }
}
