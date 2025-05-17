package com.example.daiying_backend.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class LvShare {
    private Integer id;
    private Integer userId;
    private String title;
    private String context;
    private String username;
    private Date createTime;
}
