package com.mycompany.invoice.controller;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.service.InvoiceServiceInterface;

public class InvoiceControllerDouchette implements InvoiceControllerInterface{
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void createInvoice() {
        System.out.println("Usage of a Scanner");
        Invoice invoice = new Invoice();
        invoice.setCustomerName("Virgin Galatic");
        invoiceService.createInvoice(invoice);
    }
}
