package com.examinationsystemmicroservices.examinationservice.examinationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.examinationsystemmicroservices.examinationservice.examinationservice.repository")
@SpringBootApplication
public class ExaminationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaminationServiceApplication.class, args);
	}

}
