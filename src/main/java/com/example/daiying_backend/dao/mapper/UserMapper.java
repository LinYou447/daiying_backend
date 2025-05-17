package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User getById(Integer id);

    User getByName(String username);

    List<User> getAllUser(String username, String phone);

    List<User> getAllUserByRole(String role);

    User getUserByPhone(String phone);

    Integer createUser(User user);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);
}
