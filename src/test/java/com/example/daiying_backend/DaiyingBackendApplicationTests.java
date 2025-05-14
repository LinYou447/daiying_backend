package com.example.daiying_backend;

import com.example.daiying_backend.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DaiyingBackendApplicationTests {

    @Test
    void contextLoads() {
    }

    @SpringBootTest
    public class UserMapperTest {
        @Autowired
        private UserMapper userMapper;

        @Test
        void testUserMapperNotNull() {
            assertNotNull(userMapper, "UserMapper未成功注入");
        }
    }
}
