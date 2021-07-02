package com.mycompany.invoice.repository;

import com.mycompany.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceRepositoryInterface {
    void create(Invoice invoice);
    List<Invoice> list();
}
