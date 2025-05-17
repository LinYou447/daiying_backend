package com.example.daiying_backend.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface InitMapper {
    @Insert("INSERT INTO user (username, password,phone,role,email,create_time) VALUES (#{username}, #{password}, #{phone}, #{role}, #{email}, #{createTime})")
    int insertInitialUserData(@Param("username") String username,
                              @Param("password") String password,
                              @Param("phone") String phone,
                              @Param("role") String role,
                              @Param("email") String email,
                              @Param("createTime") Date createTime);

    @Select("SELECT COUNT(*) FROM user WHERE username = #{username}")
    int countByAdmin(@Param("username") String username);

    @Select("SELECT COUNT(*) FROM role WHERE name = #{name}")
    int countByRoleName(@Param("name") String name);

    @Insert("INSERT INTO role (name,state,des,create_time) VALUES (#{name},#{state},#{des},#{createTime})")
    int insertInitialRoleData(@Param("name") String name,
                              @Param("state") Boolean state,
                              @Param("des") String des,
                              @Param("createTime") Date createTime);
}
