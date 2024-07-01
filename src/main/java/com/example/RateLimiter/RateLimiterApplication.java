
// version-0.1
/* code sets up a basic rate limiter using Spring Boot and Redis.
 It includes a configurable limit, a mechanism to notify clients when the limit is exceeded, 
 and a system designed to be highly available, low latency, and scalable*/

// Ensure High Availability check
/* -we Use a Redis cluster to distribute rate limiting data across multiple nodes.
   - we Use a load balancer to distribute incoming requests across multiple instances of the Spring Boot application. 
*/

// Ensure Failover check
 /*We need to Implement Redis Sentinel for failover and redundancy.*/

// Optimize for Low Latency
/* we Use Redis as an in-memory store for quick access to rate limiting data. and algorithm like Token Bucket for handling rate limits*/

// Design for Scalability check
/* Horizontal Scaling- will Deploy multiple instances of the Spring Boot application to handle increased load.
   Distributed Rate Limiting-will Use a distributed key-value store like Redis to share rate limit data across multiple instances.
   Sharding - Will Implement sharding to distribute the load across multiple Redis nodes.
*/
package com.example.RateLimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// bootstrap
@SpringBootApplication
public class RateLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimiterApplication.class, args);
	}

}
