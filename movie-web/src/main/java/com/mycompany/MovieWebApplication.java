package com.mycompany;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieWebApplication.class, args);
	}

	@Bean
	public Hibernate5Module datatypeHibernateModule() {
		return new Hibernate5Module();
	}

}
