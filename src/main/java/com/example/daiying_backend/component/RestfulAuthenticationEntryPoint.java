package com.example.daiying_backend.component;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.example.daiying_backend.config.CommonResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 没有登录的处理类
 */
@Component
public class RestfulAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        JSON parse = JSONUtil.parse(CommonResult.unauthorized());
        response.getWriter().println(parse);
        response.getWriter().flush();//释放内存
    }
}
