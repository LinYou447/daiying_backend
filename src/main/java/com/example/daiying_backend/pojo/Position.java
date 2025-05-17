package com.example.daiying_backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Position {
    private Integer id;
    private String name;
    private Integer companyId;
    private String cpmpanyname;
    private String positionCode;
    private String recruitmentType;
    private String country;
    private String category;
    private String money;
    private String workLocation;
    private String jobDescription;
    private String jobRequirements;
    private String degree;
    private String state;
    private String msg;
    private Date createTime;
}
