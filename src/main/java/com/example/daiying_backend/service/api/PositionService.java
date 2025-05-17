package com.example.daiying_backend.service.api;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Biographical;
import com.example.daiying_backend.pojo.Position;
import com.example.daiying_backend.pojo.Search;

public interface PositionService {
    CommonResult getAllPosition(Search search);

    CommonResult getByType(String type);

    CommonResult getByCompanyId(Integer companyId);

    CommonResult createPosition(Position position);

    CommonResult updatePosition(Position position);

    CommonResult deleteById(Integer id);

    CommonResult getById(Integer id);
}
