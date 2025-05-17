package com.example.daiying_backend.service.api;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Company;
import com.example.daiying_backend.pojo.Position;

import java.util.List;

public interface CompanyService {
    CommonResult createCompany(Company company);

    CommonResult updateCompany(Company company);

    CommonResult getById(Integer id);

    CommonResult getByUserId(Integer userId);

    CommonResult getAllCompany(String name, String phone);

    CommonResult deleteById(Integer id);
}
