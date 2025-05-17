package com.example.daiying_backend.service.api;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Position;
import com.example.daiying_backend.pojo.PositionRequest;
import com.example.daiying_backend.pojo.Search;

import java.util.List;

public interface PositionRequestService {
    CommonResult getById(Integer id);

    CommonResult getAllPositionRequest(Search search);

    CommonResult createPositionRequest(PositionRequest positionRequest);

    CommonResult updatePositionRequest(PositionRequest positionRequest);

    CommonResult deleteById(Integer id);

    CommonResult getByUserId(Integer userId);
}
