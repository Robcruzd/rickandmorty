package com.test.rickandmorty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.test.infrastructure.jpa.repositories")
@EntityScan(basePackages = "com.test.infrastructure.jpa.entities")
@ComponentScan(basePackages = {"com.test"})
public class RickandmortyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickandmortyApplication.class, args);
	}

}
