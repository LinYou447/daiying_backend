package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.Biographical;
import com.example.daiying_backend.pojo.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

    Integer createCompany(Company company);

    Integer updateCompany(Company company);

    Company getById(Integer id);

    Company getByUserId(Integer id);

    List<Company> getAllCompany(String name, String phone);

    Integer deleteById(Integer id);
}
