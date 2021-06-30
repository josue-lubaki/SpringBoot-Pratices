package com.mycompany.invoice.repository;

import com.mycompany.invoice.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepositoryMichel implements InvoiceRepositoryInterface {
    private static List<Invoice> invoices = new ArrayList<>();

    public void create (Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoices added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }
}
