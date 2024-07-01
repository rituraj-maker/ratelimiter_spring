package com.example.RateLimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Rate Limiter Interceptor.
//Implement an interceptor to check rate limits before processing the request. 

@Component
class RateLimiterInterceptor implements HandlerInterceptor {
    @Autowired
    private RateLimiterService rateLimiterService;  // service autowired

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientId = request.getHeader("Client-ID");
        if (rateLimiterService.isRateLimited(clientId)) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.getWriter().write("Rate limit exceeded. Try again later.");
            return false;
        }
        return true;
    }
}