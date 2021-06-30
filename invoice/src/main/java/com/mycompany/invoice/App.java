package com.mycompany.invoice;

import com.mycompany.invoice.controller.InvoiceController;
import com.mycompany.invoice.controller.InvoiceControllerMichel;

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
            invoiceController.createInvoice();
        }
        else if(configuration == 2){
            InvoiceControllerMichel invoiceController = new InvoiceControllerMichel();
            invoiceController.createInvoice();
        }


    }
}
