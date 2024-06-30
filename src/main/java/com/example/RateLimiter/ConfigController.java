package com.example.RateLimiter;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.config.environment.Environment;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/config")
//@PropertySource("classpath:application.properties")
class ConfigController {
    @Autowired
    private RateLimiterConfig rateLimiterConfig;
    @Autowired
   private Environment environment;
    

    @GetMapping("/refresh")
    public ResponseEntity<String> refreshConfig() {
    	
        rateLimiterConfig.setMaxRequests(Integer.parseInt(environment.getProperty("rate-limiter.max-requests")));
        rateLimiterConfig.setWindowSize(Integer.parseInt(environment.getProperty("rate-limiter.window-size")));
        return ResponseEntity.ok("Config reloaded");
    }
}