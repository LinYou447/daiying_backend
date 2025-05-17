package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.Biographical;
import com.example.daiying_backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BiographicalMapper {
    Biographical getById(Integer id);

    List<Biographical> getAllBiographical();

    Biographical getByPhone(String phone);

    Biographical getByUserId(Integer userId);

    Integer createBiographical(Biographical biographical);

    Integer updateBiographical(Biographical biographical);

    Integer deleteById(Integer id);
}
