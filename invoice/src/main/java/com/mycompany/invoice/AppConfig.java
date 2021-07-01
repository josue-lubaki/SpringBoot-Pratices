package com.mycompany.invoice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(
    basePackages =
        {
            "com.mycompany.invoice.controller.web",
            "com.mycompany.invoice.repository.database",
            "com.mycompany.invoice.service.prefix"
        }
)
@PropertySource("classpath:application.properties")
public class AppConfig {

}
