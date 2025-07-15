package com.microservicescommunitycenter.Microservices.community.centers.project.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Microservices Community Centers")
                        .version("1.0.0")
                        .description("Interactive documentation of the management API de Community Centers"));
    }
}
