package com.cognitech.springbootjpahibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootjpahibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpahibernateApplication.class, args);
		System.out.println("Server is ready.........");
	}

	//---------------------------------------------------------------------------------------------
	@Bean
	public CommandLineRunner commandLineRunner(String[] args)
	{
		return runner -> System.out.println("CommandLineRunner");
	}
}
