package com.mycompany.invoice.repository.database;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {
    private static List<Invoice> invoices = new ArrayList<>();

    public void create (Invoice invoice){
        invoices.add(invoice);
        System.out.println("Database : Invoices added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }
}
