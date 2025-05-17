package com.example.daiying_backend.pojo;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class Company {
    private Integer id;
    private String name;
    private String username;
    private Integer userId;
    private String address;
    private String phone;
    private String qualification;
    private BigInteger capital;
    private String legalPerson;
    private Date createTime;
}
