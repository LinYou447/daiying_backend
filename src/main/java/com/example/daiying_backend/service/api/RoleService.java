package com.example.daiying_backend.service.api;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Role;
import com.example.daiying_backend.pojo.Search;

import java.util.List;

public interface RoleService {
    CommonResult getById(Integer id);

    CommonResult getAllRole(Search search);

    CommonResult createRole(Role role);

    CommonResult updateRole(Role role);

    CommonResult deleteById(Integer id);
}
