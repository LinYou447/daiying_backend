package com.example.daiying_backend.pojo;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String role;
    private Date createTime;
}
