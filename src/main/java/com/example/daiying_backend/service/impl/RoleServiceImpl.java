package com.example.daiying_backend.service.impl;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.dao.mapper.RoleMapper;
import com.example.daiying_backend.pojo.Role;
import com.example.daiying_backend.pojo.Search;
import com.example.daiying_backend.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public CommonResult getById(Integer id) {
        try {
            Role byId = roleMapper.getById(id);
            return CommonResult.success(byId);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult getAllRole(Search search) {
        try {
            List<Role> allRole = roleMapper.getAllRole(search);
            return CommonResult.success(allRole);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult createRole(Role role) {
        try {
            role.setCreateTime(new Date());
            roleMapper.createRole(role);
            return CommonResult.success("创建成功", null);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult updateRole(Role role) {
        try {
            roleMapper.updateRole(role);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult deleteById(Integer id) {
        try {
            roleMapper.deleteById(id);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }
}
