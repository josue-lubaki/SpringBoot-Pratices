package com.mycompany.invoice.core.service;

import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.repository.InvoiceRepositoryInterface;

import java.util.List;

public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    List<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
