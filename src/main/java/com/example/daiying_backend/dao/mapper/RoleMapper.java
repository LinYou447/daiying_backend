package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.Position;
import com.example.daiying_backend.pojo.Role;
import com.example.daiying_backend.pojo.Search;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    Role getById(Integer id);

    List<Role> getAllRole(Search search);

    Integer createRole(Role role);

    Integer updateRole(Role role);

    Integer deleteById(Integer id);
}
