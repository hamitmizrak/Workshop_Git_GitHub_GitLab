package com.hamitmizrak.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigBean {

    @Bean
    public OpenAPI openAPIMethod() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Spring Boot")
                                .contact(
                                        new Contact()
                                                .email("hamitmizrak@gmail.com"))
                                .version("v1")
                                .description("tanımlama"));
    }
}
