package com.mycompany.invoice;

import com.mycompany.invoice.controller.InvoiceControllerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Classe de lancement d'Application
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        InvoiceControllerInterface invoiceController =  context.getBean(InvoiceControllerInterface.class);
        invoiceController.createInvoice();
    }
}


