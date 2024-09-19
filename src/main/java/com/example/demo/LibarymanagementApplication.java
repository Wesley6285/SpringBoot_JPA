package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class LibarymanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibarymanagementApplication.class, args);
		System.out.println("Server Started");
	}

}
