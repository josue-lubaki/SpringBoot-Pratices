package com.mycompany.invoice;

import com.mycompany.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoice.service.InvoiceServiceInterface;

import java.util.Scanner;

/**
 * Classe de lancement d'Application
 */
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Quel est la Classe de controller ? ");
        String controllerClass = scan.nextLine();
        System.out.println("Quel est la Classe de service ?");
        String serviceClass = scan.nextLine();
        System.out.println("Quel est la Classe de repository ?");
        String repositoryClass = scan.nextLine();

        // Initialisation des interfaces des composants
        InvoiceControllerInterface invoiceController = null;
        InvoiceServiceInterface invoiceService = null;
        InvoiceRepositoryInterface invoiceRepository = null;

        // instanciation des composants grâce à la reflection de Java
        try {
            invoiceController = (InvoiceControllerInterface) Class.forName(controllerClass).getDeclaredConstructor().newInstance();
            invoiceService = (InvoiceServiceInterface) Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            invoiceRepository = (InvoiceRepositoryInterface) Class.forName(repositoryClass).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Démarrer les services tout en faisant l'injection des dépendances entre les composants
        if (invoiceController != null && invoiceService != null) {
            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        }

    }
}


