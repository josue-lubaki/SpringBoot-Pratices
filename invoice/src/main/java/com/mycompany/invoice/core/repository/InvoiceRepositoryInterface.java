package com.mycompany.invoice.core.repository;

import com.mycompany.invoice.core.entity.Invoice;

import java.util.List;

public interface InvoiceRepositoryInterface {
    Invoice create(Invoice invoice);
    List<Invoice> list();
    Invoice getById(String number);
}
