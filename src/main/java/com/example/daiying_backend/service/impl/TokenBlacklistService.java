package com.example.daiying_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenBlacklistService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${jwt.expiration}")
    private long expiration;

    // 将 Token 加入黑名单，并设置过期时间
    public void addToBlacklist(String token, long expirationTime) {
        long ttl = expirationTime - System.currentTimeMillis();
        if (ttl > 0) {
//            redisTemplate.opsForValue().set(token, "blacklisted", ttl, TimeUnit.MILLISECONDS);
        }
    }

    // 检查 Token 是否在黑名单中
    public boolean isBlacklisted(String token) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(token));
    }
}
