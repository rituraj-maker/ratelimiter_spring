package com.example.RateLimiter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rate-limiter")
class RateLimiterConfig {
	  
    private int maxRequests;
    private int windowSize; // in seconds
    // getters and setters
	public int getMaxRequests() {
		return maxRequests;
	}
	public void setMaxRequests(int maxRequests) {
		this.maxRequests = maxRequests;
	}
	public int getWindowSize() {
		return windowSize;
	}
	public void setWindowSize(int windowSize) {
		this.windowSize = windowSize;
	}
}


