package com.example.daiying_backend.service.api;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.pojo.LvShare;

public interface LvShareService {
    CommonResult getById(Integer id);

    CommonResult getAllShare();

    CommonResult createShare(LvShare lvShare);

    CommonResult updateShare(LvShare lvShare);

    CommonResult deleteById(Integer id);
}
