package com.example.daiying_backend.component;

import com.example.daiying_backend.config.JwtUtils;
import com.example.daiying_backend.dao.mapper.UserMapper;
import com.example.daiying_backend.pojo.User;
import com.example.daiying_backend.service.api.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtUtils jwtUtils,
                                   UserDetailsService userDetailsService,
                                   AuthenticationEntryPoint authenticationEntryPoint) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            // 排除登录路径
            if (request.getServletPath().equals("/api/user/login")
                || request.getServletPath().equals("/api/user/regedit")) {
                filterChain.doFilter(request, response);
                return;
            }
            String token = parseToken(request);
            if (token != null && jwtUtils.validateToken(token)) {
                String username = jwtUtils.extractUsername(token);
//                Claims claims = jwtUtils.extractAllClaims(token);
//                UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject());
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }else{
                throw new AuthenticationCredentialsNotFoundException("Invalid JWT token");
            }
        }catch (Exception e){
            authenticationEntryPoint.commence(request, response, new AuthenticationCredentialsNotFoundException("Authentication failed", e));
            return;
        }
        filterChain.doFilter(request, response);
    }

    // 从请求头解析 Token（Bearer <token>）
    private String parseToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Daiying ")) {
            return header.substring(8);
        }
        return null;
    }


}
