package com.primeiroprojetosb.FirstPSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.primeiroprojetosb.entities")
@ComponentScan(basePackages = "com.primeiroprojetosb")
@EnableJpaRepositories("com.primeiroprojetosb.repository")
public class FirstPsbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstPsbApplication.class, args);
	}

}
