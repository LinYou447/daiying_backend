package com.example.daiying_backend.service.impl;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.dao.mapper.PositionMapper;
import com.example.daiying_backend.dao.mapper.PositionRequestMapper;
import com.example.daiying_backend.pojo.Position;
import com.example.daiying_backend.pojo.PositionRequest;
import com.example.daiying_backend.pojo.Search;
import com.example.daiying_backend.service.api.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {


    @Autowired
    PositionMapper positionMapper;

    @Autowired
    PositionRequestMapper positionRequestMapper;

    @Override
    public CommonResult getAllPosition(Search search) {
        try {
            List<Position> allPosition = positionMapper.getAllPosition(search);
            return CommonResult.success(allPosition);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult getByType(String type) {
        return null;
    }

    @Override
    public CommonResult getByCompanyId(Integer companyId) {
        return null;
    }

    @Override
    public CommonResult createPosition(Position position) {
        try {
            position.setCreateTime(new Date());
            position.setState("待审核");
            position.setCountry("中国");
            positionMapper.createPosition(position);
            return CommonResult.success("创建成功");
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult updatePosition(Position position) {
        try {
            positionMapper.updatePosition(position);
            return CommonResult.success("修改成功");
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult deleteById(Integer id) {
        try {
            List<PositionRequest> byPositionId = positionRequestMapper.getByPositionId(id);
            if (byPositionId != null && byPositionId.size() != 0) {
                return CommonResult.faild("存在职位申请无法删除");
            }
            positionMapper.deleteById(id);
            return CommonResult.success("删除成功", null);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult getById(Integer id) {
        try {
            Position byId = positionMapper.getById(id);
            return CommonResult.success(byId);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }
}
