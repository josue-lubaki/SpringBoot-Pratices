package com.mycompany.invoice.repository.memory;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface {
    private static List<Invoice> invoices = new ArrayList<>();

    public void create (Invoice invoice){
        invoices.add(invoice);
        System.out.println("Memory : Invoices added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }
}
