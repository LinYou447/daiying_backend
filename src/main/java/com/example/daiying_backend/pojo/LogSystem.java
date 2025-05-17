package com.example.daiying_backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class LogSystem {
    private Integer id;
    private String username;
    private String phone;
    private String roleName;
    private String editDes;
    private Date createTime;
}
