package com.mycompany.invoice.service;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.InvoiceRepositoryInterface;

public interface InvoiceServiceInterface {
    void createInvoice(Invoice invoice);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
