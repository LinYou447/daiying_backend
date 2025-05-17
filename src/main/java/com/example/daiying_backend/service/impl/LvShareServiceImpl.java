package com.example.daiying_backend.service.impl;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.dao.mapper.LvShareMapper;
import com.example.daiying_backend.pojo.LvShare;
import com.example.daiying_backend.service.api.LvShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LvShareServiceImpl implements LvShareService {

    @Autowired
    LvShareMapper lvShareMapper;

    @Override
    public CommonResult getById(Integer id) {
        try {
            LvShare byId = lvShareMapper.getById(id);
            return CommonResult.success(byId);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult getAllShare() {
        try {
            List<LvShare> allShare = lvShareMapper.getAllShare();
            return CommonResult.success(allShare);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult createShare(LvShare lvShare) {
        try {
            lvShare.setCreateTime(new Date());
            lvShareMapper.createShare(lvShare);
            return CommonResult.success("发布成功", null);
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult updateShare(LvShare lvShare) {
        try {
            lvShareMapper.updateShare(lvShare);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }

    @Override
    public CommonResult deleteById(Integer id) {
        try {
            lvShareMapper.deleteById(id);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild();
        }
    }
}
