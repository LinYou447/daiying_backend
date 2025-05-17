package com.example.daiying_backend.service.api;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.Biographical;

import java.util.List;

public interface BiographicalService {
    CommonResult getById(Integer id);

    CommonResult getAllBiographical();

    CommonResult getByPhone(String phone);

    CommonResult getByUserId(Integer userId);

    CommonResult createBiographical(Biographical biographical);

    CommonResult updateBiographical(Biographical biographical);

    CommonResult deleteById(Integer id);
}
