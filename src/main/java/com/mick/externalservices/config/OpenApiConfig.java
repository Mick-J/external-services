package com.mick.externalservices.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Trip-Advisor: external service - mocked API")
                        .description("This page contains the API details for the external services and is part of the project: [Trip-advisor](https://github.com/Mick-J/trip-advisor): to play with Scalability Test with Java Virtual Threads.<br/>" +
                                "By default It uses port 7070.<br/>" +
                                "You can change the port by running the application with parameter java -jar external-services.jar --server.port=7070<br/>" +
                                "Each API is intentionally setup to delay the response by 1 second.<br/>")
                        .version("1.0.0"));
    }
}