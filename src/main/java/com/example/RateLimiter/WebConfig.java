package com.example.RateLimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// Register Interceptor.
 //Add the interceptor to the Spring Boot application.


@Configuration
class WebConfig implements WebMvcConfigurer {
    @Autowired
    private RateLimiterInterceptor rateLimiterInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimiterInterceptor);
    }
}
