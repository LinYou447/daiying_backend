package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Property;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    User getById(Integer id);
    User getByName(String username);
    List<User> getAllUser();
    User getUserByPhone(String phone);
    int createUser(User user);
    int updateUser(User user);
    int deleteUserById(Integer id);
}
