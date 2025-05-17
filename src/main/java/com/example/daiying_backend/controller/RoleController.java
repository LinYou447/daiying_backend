package com.example.daiying_backend.controller;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Role;
import com.example.daiying_backend.pojo.Search;
import com.example.daiying_backend.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/create")
    public CommonResult createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @PostMapping("/update")
    public CommonResult updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @DeleteMapping("/delete")
    public CommonResult deleteRole(@RequestParam Integer id){
        return roleService.deleteById(id);
    }

    @PostMapping("/getAll")
    public CommonResult getAll(@RequestBody Search search){
        return roleService.getAllRole(search);
    }

    @GetMapping("/getById")
    public CommonResult getById(@RequestParam Integer id){
        return roleService.getById(id);
    }
}
