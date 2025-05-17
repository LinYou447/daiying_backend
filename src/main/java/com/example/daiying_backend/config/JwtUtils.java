package com.example.daiying_backend.config;

import com.example.daiying_backend.pojo.User;
import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Primary
public class JwtUtils {


    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public static String SECRET_KEY;

    public static long EXPIRATION_TIME;

    private Date expirationDate;

    @PostConstruct
    public void init() {
        // 确认此处打印的值是否与配置一致
        System.out.println("init() expiration = " + expiration);
        SECRET_KEY = secret;
        EXPIRATION_TIME = expiration;
        this.expirationDate = new Date(System.currentTimeMillis() + expiration);
    }

    public void setExpiration() {
        // 检查此处是否因 expirationDate 未初始化导致问题
        System.out.println("setExpiration() expiration = " + expiration);
        // ...
    }


    // 生成 Token
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
//        claims.put("roles",userDetails.getRole());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    // 校验 Token 是否有效
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 提取用户名
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 提取 Claims
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // 解析 Token 获取 Claims
    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            System.err.println("令牌已过期: " + e.getMessage());
            throw new RuntimeException("令牌已过期", e);
        } catch (UnsupportedJwtException e) {
            System.err.println("不支持的令牌格式: " + e.getMessage());
            throw new RuntimeException("不支持的令牌格式", e);
        } catch (MalformedJwtException e) {
            System.err.println("令牌格式错误: " + e.getMessage());
            throw new RuntimeException("令牌格式错误", e);
        } catch (SignatureException e) {
            System.err.println("签名无效: " + e.getMessage());
            throw new RuntimeException("签名无效", e);
        } catch (IllegalArgumentException e) {
            System.err.println("令牌参数错误: " + e.getMessage());
            throw new RuntimeException("令牌参数错误", e);
        }
    }

    // 检查 Token 是否过期
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 提取过期时间
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
