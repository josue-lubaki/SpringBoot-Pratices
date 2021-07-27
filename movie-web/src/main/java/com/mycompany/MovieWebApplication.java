package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class MovieWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieWebApplication.class, args);
	}

}
