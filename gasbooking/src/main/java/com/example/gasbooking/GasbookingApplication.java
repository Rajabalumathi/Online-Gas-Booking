package com.example.gasbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
@EnableSwagger2
public class GasbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasbookingApplication.class, args);
	}

}
