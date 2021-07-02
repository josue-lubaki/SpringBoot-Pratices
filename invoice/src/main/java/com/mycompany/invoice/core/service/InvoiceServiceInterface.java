package com.mycompany.invoice.core.service;

import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.repository.InvoiceRepositoryInterface;

import java.util.List;

public interface InvoiceServiceInterface {
    void createInvoice(Invoice invoice);
    List<Invoice> getInvoiceList();
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
