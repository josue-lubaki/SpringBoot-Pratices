package com.mycompany.invoice;

import com.mycompany.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoice.service.InvoiceServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Classe de lancement d'Application
 */
public class App {
    public static void main(String[] args) {
        // instancier une application contexte (conteneur leger) sur la base d'un fichier XML qui se trouve sur mon ClassPath
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        InvoiceControllerInterface invoiceController =  context.getBean(InvoiceControllerInterface.class);
        invoiceController.createInvoice();
    }
}


