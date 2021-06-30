package com.mycompany.invoice;

import com.mycompany.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoice.controller.InvoiceControllerKeyboard;
import com.mycompany.invoice.controller.InvoiceControllerDouchette;
import com.mycompany.invoice.controller.InvoiceControllerWeb;
import com.mycompany.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoice.repository.InvoiceRepositoryMemory;
import com.mycompany.invoice.repository.InvoiceRepositoryDatabase;
import com.mycompany.invoice.service.InvoiceServiceInterface;
import com.mycompany.invoice.service.InvoiceServiceNumber;
import com.mycompany.invoice.service.InvoiceServicePrefix;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quel est le type de controller ? (Keyboard, web, Douchette)");
        String controllerType = scan.nextLine();
        System.out.println("Quel est le type de service ? (number, prefix)");
        String serviceType = scan.nextLine();
        System.out.println("Quel est le type de repository ? (memory, Database)");
        String repositoryType = scan.nextLine();



        InvoiceControllerInterface invoiceController = null;
        switch (controllerType.toLowerCase()){
            case "keyboard" :
                invoiceController = new InvoiceControllerKeyboard();
                break;
            case "web":
                invoiceController = new InvoiceControllerWeb();
                break;
            case "douchette":
                invoiceController = new InvoiceControllerDouchette();
                break;
        }

        InvoiceServiceInterface invoiceService = null;

        switch(serviceType.toLowerCase()){
            case "number":
                invoiceService = new InvoiceServiceNumber();
                break;
            case "prefix":
                invoiceService = new InvoiceServicePrefix();
                break;
        }
        InvoiceRepositoryInterface invoiceRepository = null;

        switch(repositoryType.toLowerCase()){
            case "memory":
                invoiceRepository = new InvoiceRepositoryMemory();
                break;
            case "database":
                invoiceRepository = new InvoiceRepositoryDatabase();
                break;
        }

        invoiceController.setInvoiceService(invoiceService);
        invoiceService.setInvoiceRepository(invoiceRepository);
        invoiceController.createInvoice();
    }
}
     /* System.out.println("Quel est la Classe de controller ? ");
        String controllerClass = scan.nextLine();
        System.out.println("Quel est la Classe de service ?");
        String serviceClass = scan.nextLine();
        System.out.println("Quel est la Classe de repository ?");
        String repositoryClass = scan.nextLine();*/

 /*  try {
            invoiceController = (InvoiceControllerInterface) Class.forName(controllerClass).getDeclaredConstructor().newInstance();
            invoiceService = (InvoiceServiceInterface) Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            invoiceRepository = (InvoiceRepositoryInterface) Class.forName(repositoryClass).getDeclaredConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }*/