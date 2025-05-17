package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.Biographical;
import com.example.daiying_backend.pojo.Position;
import com.example.daiying_backend.pojo.Search;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionMapper {
    Position getById(Integer id);

    List<Position> getAllPosition(Search search);

    Position getByType(String type);

    List<Position> getByCompanyId(Integer companyId);

    Integer createPosition(Position position);

    Integer updatePosition(Position position);

    Integer deleteById(Integer id);
}
