package com.mycompany.invoice.controller;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.service.InvoiceServiceInterface;

import java.util.Scanner;

public class InvoiceControllerWeb implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void createInvoice(){

        Scanner scan = new Scanner(System.in);
        String customerName = "Tesla";

        // instancier la facture et y inscrire le nom du client
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        invoiceService.createInvoice(invoice);
    }
}
