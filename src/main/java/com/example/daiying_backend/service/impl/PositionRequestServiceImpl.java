package com.example.daiying_backend.service.impl;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.dao.mapper.PositionRequestMapper;
import com.example.daiying_backend.pojo.PositionRequest;
import com.example.daiying_backend.pojo.Search;
import com.example.daiying_backend.service.api.PositionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PositionRequestServiceImpl implements PositionRequestService {

    @Autowired
    PositionRequestMapper positionRequestMapper;

    @Override
    public CommonResult getById(Integer id) {
        try {
            PositionRequest byId = positionRequestMapper.getById(id);
            return CommonResult.success(byId);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult getAllPositionRequest(Search search) {
        try {
            List<PositionRequest> allPositionRequest = positionRequestMapper.getAllPositionRequest(search);
            return CommonResult.success(allPositionRequest);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult createPositionRequest(PositionRequest positionRequest) {
        try {
            if (positionRequest.getBiographicalId() == null) {
                return CommonResult.faild("请完善简历信息");
            }
            positionRequest.setCreateTime(new Date());
            positionRequest.setState("待审核");
            positionRequestMapper.createPositionRequest(positionRequest);
            return CommonResult.success("提交成功", null);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult updatePositionRequest(PositionRequest positionRequest) {
        try {
            positionRequestMapper.updatePositionRequest(positionRequest);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult deleteById(Integer id) {
        try {
            positionRequestMapper.deleteById(id);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult getByUserId(Integer userId) {
        try {
            List<PositionRequest> byUserId = positionRequestMapper.getByUserId(userId);
            return CommonResult.success(byUserId);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }
}
