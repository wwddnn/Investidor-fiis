package com.nicodemus.fiis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.nicodemus.fiis"})
public class FiisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiisApplication.class, args);
	}
}
