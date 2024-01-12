package com.yassinesmac.api;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(ApiApplication.class, args);
		System.out.println(ctx.getEnvironment());
	}

}
