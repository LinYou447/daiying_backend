package com.example.daiying_backend.service.impl;

import com.example.daiying_backend.config.CommonResult;
import com.example.daiying_backend.dao.mapper.BiographicalMapper;
import com.example.daiying_backend.pojo.Biographical;
import com.example.daiying_backend.service.api.BiographicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class BiographicalServiceImpl implements BiographicalService {

    @Autowired
    BiographicalMapper biographicalMapper;

    @Override
    public CommonResult getById(Integer id) {
        try {
            Biographical byId = biographicalMapper.getById(id);
            return CommonResult.success(byId);
        } catch (Exception e) {
            return CommonResult.faild("获取失败！");
        }
    }

    @Override
    public CommonResult getAllBiographical() {
        try {
            biographicalMapper.getAllBiographical();
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild("获取失败！");
        }
    }

    @Override
    public CommonResult getByPhone(String phone) {
        try {
            biographicalMapper.getByPhone(phone);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild("获取失败！");
        }
    }

    @Override
    public CommonResult getByUserId(Integer userId) {
        try {
            Map<String, String> empty = new HashMap();
            Biographical byUserId = biographicalMapper.getByUserId(userId);
            if (byUserId == null) {
                return CommonResult.success(empty);
            }
            return CommonResult.success(byUserId);
        } catch (Exception e) {
            return CommonResult.faild("获取失败！");
        }
    }

    @Override
    public CommonResult createBiographical(Biographical biographical) {
        try {
            if (biographical.getId() != null) {
                biographical.setCreateTime(new Date());
                biographicalMapper.updateBiographical(biographical);
                return CommonResult.success();
            } else {
                biographical.setCreateTime(new Date());
                biographicalMapper.createBiographical(biographical);
                return CommonResult.success();
            }
        } catch (Exception e) {
            return CommonResult.faild("创建失败！");
        }
    }

    @Override
    public CommonResult updateBiographical(Biographical biographical) {
        try {
            biographicalMapper.updateBiographical(biographical);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild("修改失败！");
        }
    }

    @Override
    public CommonResult deleteById(Integer id) {
        try {
            biographicalMapper.deleteById(id);
            return CommonResult.success();
        } catch (Exception e) {
            return CommonResult.faild("删除失败！");
        }
    }
}
