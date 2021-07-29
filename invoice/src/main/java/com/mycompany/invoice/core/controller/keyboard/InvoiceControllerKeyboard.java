package com.mycompany.invoice.core.controller.keyboard;

import com.mycompany.invoice.core.controller.InvoiceControllerInterface;
import com.mycompany.invoice.core.entity.Customer;
import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public String createInvoice(Invoice invoice){
        System.out.println( "What is the customer name ?");
        Scanner scan = new Scanner(System.in);
        String customerName = scan.nextLine();

        // instancier la facture et y inscrire le nom du client
        invoice = new Invoice();
        Customer customer = new Customer(customerName);
        invoice.setCustomer(customer);

        invoiceService.createInvoice(invoice);
        return null;
    }
}
