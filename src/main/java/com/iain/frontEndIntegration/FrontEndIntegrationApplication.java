package com.iain.frontEndIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = "com.iain.frontEndIntegration")
@EntityScan(basePackages = "com.iain.frontEndIntegration")
public class FrontEndIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontEndIntegrationApplication.class, args);
	}

}
