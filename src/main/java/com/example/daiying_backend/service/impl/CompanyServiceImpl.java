package com.example.daiying_backend.service.impl;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.dao.mapper.CompanyMapper;
import com.example.daiying_backend.dao.mapper.UserCompanyMapper;
import com.example.daiying_backend.dao.mapper.UserMapper;
import com.example.daiying_backend.pojo.Company;
import com.example.daiying_backend.pojo.User;
import com.example.daiying_backend.pojo.UserCompanyPojo;
import com.example.daiying_backend.service.api.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    UserCompanyMapper userCompanyMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public CommonResult createCompany(Company company) {
        try {
            company.setCreateTime(new Date());
            companyMapper.createCompany(company);
            UserCompanyPojo userCompanyPojo = new UserCompanyPojo();
            userCompanyPojo.setUserId(company.getUserId());
            userCompanyPojo.setCompanyId(company.getId());
            userCompanyPojo.setCreateTime(new Date());
            userCompanyMapper.createUserCompany(userCompanyPojo);
            User byId = userMapper.getById(company.getUserId());
            if (!byId.getRole().contains("COMPANY")) {
                byId.setRole(byId.getRole() + ",COMPANY");
                userMapper.updateUser(byId);
            }
            return CommonResult.success("保存成功", null);
        } catch (Exception e) {
            return CommonResult.faild();
        }

    }

    @Override
    public CommonResult updateCompany(Company company) {
        try {
            companyMapper.updateCompany(company);
            UserCompanyPojo byCompanyId = userCompanyMapper.getByCompanyId(company.getId());
            byCompanyId.setUserId(company.getUserId());
            userCompanyMapper.updateUserCompany(byCompanyId);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult getById(Integer id) {
        try {
            Company byId = companyMapper.getById(id);
            return CommonResult.success(byId);
        } catch (Exception e) {
            return CommonResult.faild("企业信息不存在");
        }
    }

    @Override
    public CommonResult getByUserId(Integer userId) {
        try {
            Company byUserId = companyMapper.getByUserId(userId);
            return CommonResult.success(byUserId);
        } catch (Exception e) {
            return CommonResult.faild("企业信息不存在");
        }
    }

    @Override
    public CommonResult getAllCompany(String name, String phone) {
        try {
            List<Company> allCompany = companyMapper.getAllCompany(name, phone);
            return CommonResult.success(allCompany);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult deleteById(Integer id) {
        try {
            companyMapper.deleteById(id);
            UserCompanyPojo byCompanyId = userCompanyMapper.getByCompanyId(id);
            if (byCompanyId != null) {
                userCompanyMapper.deleteByCompanyId(id);
            }
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }
}
