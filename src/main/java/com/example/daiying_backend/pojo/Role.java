package com.example.daiying_backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Integer id;
    private String name;
    private String des;
    private Boolean state;
    private Date createTime;
}
