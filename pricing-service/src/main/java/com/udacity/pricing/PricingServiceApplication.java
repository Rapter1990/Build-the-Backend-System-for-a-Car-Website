package com.udacity.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Creates a Spring Boot Application to run the Pricing Service.
 * TODO: Convert the application from a REST API to a microservice. (DONE)
 */
@SpringBootApplication
@EnableEurekaClient
public class PricingServiceApplication {

    // http://192.168.1.104:1001/services/price?vehicleId=1
    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }

}
