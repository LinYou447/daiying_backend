package com.example.daiying_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://localhost:8081")); // 允许的前端域名
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 允许的 HTTP 方法
        config.setAllowedHeaders(Arrays.asList("*")); // 允许所有请求头
        config.setAllowCredentials(true); // 允许携带 Cookie 或 Authorization 头
        config.setMaxAge(3600L); // 预检请求缓存时间（秒）

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 对所有路径生效
        return source;
    }
}