package com.mycompany.invoice;

import com.mycompany.invoice.controller.InvoiceController;
import com.mycompany.invoice.controller.InvoiceControllerChambouleToutMagasin2;
import com.mycompany.invoice.controller.InvoiceControllerMichel;
import com.mycompany.invoice.repository.InvoiceRepository;
import com.mycompany.invoice.repository.InvoiceRepositoryMichel;
import com.mycompany.invoice.service.InvoiceService;
import com.mycompany.invoice.service.InvoiceServiceMichel;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("Dans quelle configuration êtes-vous ?");
        Scanner scan = new Scanner(System.in);
        int configuration = scan.nextInt();

        if(configuration == 1) {
            InvoiceController invoiceController = new InvoiceController();
            InvoiceService invoiceService = new InvoiceService();
            invoiceController.setInvoiceService(invoiceService);
            InvoiceRepository invoiceRepository = new InvoiceRepository();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        }
        else if(configuration == 2){
            InvoiceControllerMichel invoiceController = new InvoiceControllerMichel();
            InvoiceServiceMichel invoiceService = new InvoiceServiceMichel();
            invoiceController.setInvoiceService(invoiceService);
            InvoiceRepositoryMichel invoiceRepository = new InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        }
        else if(configuration == 3){
            InvoiceControllerMichel invoiceController = new InvoiceControllerMichel(); // controller avec formulaire web
            InvoiceService invoiceService = new InvoiceService();
            invoiceController.setInvoiceService(invoiceService);
            InvoiceRepositoryMichel invoiceRepository = new InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        }
        else if(configuration == 4){
            InvoiceControllerChambouleToutMagasin2 invoiceController = new InvoiceControllerChambouleToutMagasin2(); // controller avec scanner product
            InvoiceService invoiceService = new InvoiceService();
            invoiceController.setInvoiceService(invoiceService);
            InvoiceRepositoryMichel invoiceRepository = new InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        }


    }
}
