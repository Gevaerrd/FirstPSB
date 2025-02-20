package com.primeiroprojetosb.FirstPSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.primeiroprojetosb") // Le as paginas a partir dessa pasta
public class FirstPsbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstPsbApplication.class, args);
	}

}
