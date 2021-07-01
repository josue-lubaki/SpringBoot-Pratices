package com.mycompany.movie;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
    basePackages =
        {
            "com.mycompany.movie.service",
            "com.mycompany.movie.controller",
            "com.mycompany.movie.repository.file"
        }
)
@PropertySource("classpath:application.properties")
public class AppConfig {
}
