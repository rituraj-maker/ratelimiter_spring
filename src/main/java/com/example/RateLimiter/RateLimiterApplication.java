package com.example.RateLimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.config.environment.Environment;

@SpringBootApplication
public class RateLimiterApplication {
//	private Environment env;
	public static void main(String[] args) {
		SpringApplication.run(RateLimiterApplication.class, args);
	}

}
