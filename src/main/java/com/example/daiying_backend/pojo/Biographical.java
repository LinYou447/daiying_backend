package com.example.daiying_backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Biographical {
    private Integer id;
    private Integer userId;
    private String name;
    private String sex;
    private String email;
    private String phone;
    private String city;
    private String nativePlace;
    private String edu;
    private String eduBack;
    private String internshipExperience;
    private String certificateSkills;
    private String selfEvaluation;
    private Date createTime;
    private String major;
}
