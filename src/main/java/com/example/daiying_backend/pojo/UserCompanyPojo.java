package com.example.daiying_backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserCompanyPojo {
    private Integer id;
    private Integer userId;
    private Integer companyId;
    private Date createTime;
}
