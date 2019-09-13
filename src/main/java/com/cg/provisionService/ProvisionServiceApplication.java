package com.cg.provisionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.cg.provisionService.*")
public class ProvisionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvisionServiceApplication.class, args);
	}

}
