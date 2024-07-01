package com.example.RateLimiter;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.config.environment.Environment;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Reload Configuration:
//- Implement a method to reload configuration without restarting the application.

@RestController
@RequestMapping("/config")
class ConfigController {
    @Autowired
    private RateLimiterConfig rateLimiterConfig;       // configuration  autowired
    @Autowired
   private Environment environment;          // environment autowired
    

    @GetMapping("/refresh")
    public ResponseEntity<String> refreshConfig() {
    	// read properties from applications.yml/properties file
        rateLimiterConfig.setMaxRequests(Integer.parseInt(environment.getProperty("rate-limiter.max-requests")));
        rateLimiterConfig.setWindowSize(Integer.parseInt(environment.getProperty("rate-limiter.window-size")));
        return ResponseEntity.ok("Config reloaded");
    }
}