package com.example.daiying_backend.controller;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Company;
import com.example.daiying_backend.pojo.Search;
import com.example.daiying_backend.service.api.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/createCompany")
    public CommonResult createCompany(@RequestBody Company company){
        return companyService.createCompany(company);
    }

    @PostMapping("/updateCompany")
    public CommonResult updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @GetMapping("/getById")
    public CommonResult getById(@RequestParam Integer id){
        return companyService.getById(id);
    }

    @PostMapping("/getAllCompany")
    public CommonResult getAllCompany(@RequestBody Search search){
        return companyService.getAllCompany(search.getName(),search.getPhone());
    }

    @DeleteMapping("/deleteById")
    public CommonResult deleteById(@RequestParam Integer id){
        return companyService.deleteById(id);
    }

    @GetMapping("/getByUserId")
    public CommonResult getByUserId(@RequestParam Integer userId){
        return companyService.getByUserId(userId);
    }
}
