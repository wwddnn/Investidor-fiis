package com.nicodemus.fiis;

import com.nicodemus.fiis.repositories.InvestidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.nicodemus.fiis"})
public class FiisApplication {

	@Autowired
	private InvestidorRepository investidorRepository;

	public static void main(String[] args) {
		SpringApplication.run(FiisApplication.class, args);
	}


}
