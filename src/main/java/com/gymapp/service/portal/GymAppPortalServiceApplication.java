package com.gymapp.service.portal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = "com.gymapp.service.portal")
@SpringBootApplication
@EnableScheduling
public class GymAppPortalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymAppPortalServiceApplication.class, args);
    }

}

