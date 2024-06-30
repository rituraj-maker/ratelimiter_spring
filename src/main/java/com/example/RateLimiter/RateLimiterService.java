package com.example.RateLimiter;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
class RateLimiterService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RateLimiterConfig config;

    public boolean isRateLimited(String clientId) {
        String key = "rate:limit:" + clientId;
        long currentTime = System.currentTimeMillis() / 1000;
        long windowStart = currentTime - config.getWindowSize();
        
        Long requestCount = redisTemplate.opsForZSet().count(key, windowStart, currentTime);
        if (requestCount == null || requestCount < config.getMaxRequests()) {
            redisTemplate.opsForZSet().add(key, currentTime, currentTime);
            redisTemplate.expire(key, config.getWindowSize(), TimeUnit.SECONDS);
            return false;
        }
        return true;
    }
}