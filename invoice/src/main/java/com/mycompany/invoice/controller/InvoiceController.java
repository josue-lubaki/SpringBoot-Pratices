package com.mycompany.invoice.controller;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.service.InvoiceServiceInterface;

import java.util.Scanner;

public class InvoiceController implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceService;

    public void createInvoice(){
        System.out.println( "What is the customer name ?");
        Scanner scan = new Scanner(System.in);
        String customerName = scan.nextLine();

        // instancier la facture et y inscrire le nom du client
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        invoiceService.createInvoice(invoice);
    }
}
