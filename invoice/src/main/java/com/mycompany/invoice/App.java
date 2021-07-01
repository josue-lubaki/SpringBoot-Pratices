package com.mycompany.invoice;

import com.mycompany.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoice.service.InvoiceServiceInterface;
import com.mycompany.invoice.service.prefix.InvoiceServicePrefix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Classe de lancement d'Application
 */

@Configuration
@ComponentScan(
    basePackages =
        {
            "com.mycompany.invoice.controller.web",
            "com.mycompany.invoice.repository.database",
            /*"com.mycompany.invoice.service.prefix"*/
        }
)
@PropertySource("classpath:application.properties")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        InvoiceControllerInterface invoiceController =  context.getBean(InvoiceControllerInterface.class);
        invoiceController.createInvoice();
    }

    @Bean
    public InvoiceServiceInterface configureInvoiceService(){
        return new InvoiceServicePrefix();
    }
}


