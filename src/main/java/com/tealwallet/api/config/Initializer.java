package com.tealwallet.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
    //private final RestTemplateConf restTemplateConf;
    private final AppProperties appProperties;

    public Initializer(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        String appName = appProperties.name();
        System.out.println("***************" + appName);
//        var s = restTemplateConf.restTemplate().getForEntity("https://jsonplaceholder.typicode.com/todos", String.class);
//        System.out.println(s.toString());
    }
}
