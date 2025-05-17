package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.UserCompanyPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCompanyMapper {
    Integer createUserCompany(UserCompanyPojo userCompanyPojo);

    UserCompanyPojo getByCompanyId(Integer companyId);

    Integer updateUserCompany(UserCompanyPojo userCompanyPojo);

    Integer deleteByCompanyId(Integer id);
}
