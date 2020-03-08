package com.example.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkShortenerApplication {

	// "./mvnw clean package" to build jar - "java -jar target/<whatever>.jar" to run.
	// "./mvnw spring-boot:run" to run

	public static void main(String[] args) {
		SpringApplication.run(LinkShortenerApplication.class, args);
	}

}
