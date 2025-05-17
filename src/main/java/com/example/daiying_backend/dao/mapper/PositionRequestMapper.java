package com.example.daiying_backend.dao.mapper;

import com.example.daiying_backend.pojo.Position;
import com.example.daiying_backend.pojo.PositionRequest;
import com.example.daiying_backend.pojo.Search;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionRequestMapper {
    PositionRequest getById(Integer id);

    List<PositionRequest> getAllPositionRequest(Search search);

    List<PositionRequest> getByUserId(Integer userId);

    List<PositionRequest> getByPositionId(Integer positionId);

    Integer createPositionRequest(PositionRequest positionRequest);

    Integer updatePositionRequest(PositionRequest positionRequest);

    Integer deleteById(Integer id);
}
