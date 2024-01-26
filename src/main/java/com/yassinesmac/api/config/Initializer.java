package com.yassinesmac.api.config;

import com.yassinesmac.api.dto.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Initializer implements CommandLineRunner {
    private final RestTemplateConf restTemplateConf;

    public Initializer(RestTemplateConf restTemplateConf) {
        this.restTemplateConf = restTemplateConf;
    }

    @Override
    public void run(String... args) throws Exception {
        var s = restTemplateConf.restTemplate().getForEntity("https://jsonplaceholder.typicode.com/todos", Todo.class);
        System.out.println(s.toString());
    }
}
