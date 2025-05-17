package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.LvShare;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LvShareMapper {
    LvShare getById(Integer id);

    List<LvShare> getAllShare();

    Integer createShare(LvShare lvShare);

    Integer updateShare(LvShare lvShare);

    Integer deleteById(Integer id);
}
