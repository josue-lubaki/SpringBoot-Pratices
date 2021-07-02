package com.mycompany.invoice.core.controller;

import com.mycompany.invoice.core.service.InvoiceServiceInterface;

public interface InvoiceControllerInterface {
    void createInvoice();
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}
