package com.amos.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.amos.lms"})
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryManagementSystemApplication.class, args);


	}


}
