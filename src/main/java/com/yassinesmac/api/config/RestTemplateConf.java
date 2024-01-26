package com.yassinesmac.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConf {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
