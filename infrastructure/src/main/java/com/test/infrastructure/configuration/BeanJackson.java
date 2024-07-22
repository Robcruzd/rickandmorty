package com.test.infrastructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanJackson {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}