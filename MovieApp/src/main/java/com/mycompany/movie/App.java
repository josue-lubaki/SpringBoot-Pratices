package com.mycompany.movie;

import com.mycompany.movie.controller.MovieController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Applicationn de demarrage par Inversion de contrôle
 */

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
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        MovieController movieController = context.getBean(MovieController.class);
        movieController.addUsingConsole();
    }
}
