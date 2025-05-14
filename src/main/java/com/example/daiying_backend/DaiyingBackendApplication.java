package com.example.daiying_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;

@SpringBootApplication()
@Controller
@EnableWebSecurity
public class DaiyingBackendApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DaiyingBackendApplication.class, args);
        String secret = context.getEnvironment().getProperty("jwt.secret");
        System.out.println("jwt.secret = " + secret);
        System.out.println("Java Version: " + System.getProperty("java.version"));
    }
}
