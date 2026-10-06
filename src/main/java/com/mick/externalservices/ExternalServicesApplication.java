package com.mick.externalservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ExternalServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalServicesApplication.class, args);
    }

}
