package com.javatpoint.springbooth2databaseEmployeeJUNIT;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({"com.javatpoint.controller","com.javatpoint.service"})
@EntityScan("com.javatpoint.entity")
@EnableJpaRepositories("com.javatpoint.repository")
@SpringBootApplication
public class SpringBootH2DatabaseEmployeeJunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2DatabaseEmployeeJunitApplication.class, args);
	}

}
