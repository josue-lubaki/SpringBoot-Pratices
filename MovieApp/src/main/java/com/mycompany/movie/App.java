package com.mycompany.movie;

import com.mycompany.movie.controller.MovieController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Applicationn de demarrage par Inversion de contrôle
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Utilisation de l'ID du bean
        MovieController movieController = context.getBean(MovieController.class);
        movieController.addUsingConsole();
    }
}
