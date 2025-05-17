package com.example.daiying_backend.config;

import com.example.daiying_backend.dao.mapper.InitMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Configuration
public class InitDatabase {
    @Autowired
    private InitMapper initMapper;

    @PostConstruct
    @Transactional
    public void init() {
        // 确保在数据源初始化后执行
        if (initMapper.countByAdmin("管理员") == 0) {
            initMapper.insertInitialUserData("管理员",
                    "$2a$12$thxU7vXXQnOx/MNoz0QeneufuKDa68iXh3tTXV0ha6OlusEbIpb5q",
                    "15203507334",
                    "ADMIN",
                    "wojibuzhu447@163.com",
                    new Date());
        }
        if (initMapper.countByRoleName("JOBSEEKERS") == 0) {
            initMapper.insertInitialRoleData("JOBSEEKERS",
                    true, "求职者", new Date());
        }
        if (initMapper.countByRoleName("COMPANY") == 0) {
            initMapper.insertInitialRoleData("COMPANY",
                    true, "企业用户", new Date());
        }
        if (initMapper.countByRoleName("ADMIN") == 0) {
            initMapper.insertInitialRoleData("ADMIN",
                    true, "管理员", new Date());
        }
    }
}
