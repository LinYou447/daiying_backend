package com.example.daiying_backend.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class PositionRequest {
    private Integer id;
    private Integer biographicalId;
    private Integer positionId;
    private Integer companyId;
    private Integer bioId;
    private String state;
    private String companyName;
    private String positionName;
    private String bioPhone;
    private String bioName;
    private String positionCode;
    private Date createTime;
    private Integer userId;
    private String mes;
}
