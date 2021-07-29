package com.mycompany.invoice.core.controller.scan;

import com.mycompany.invoice.core.controller.InvoiceControllerInterface;
import com.mycompany.invoice.core.entity.Customer;
import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    /**
     * Methode qui permet de créer la facture et le Customer
     * Ignorer le fait que le Customer peut déjà exister
     * */
    @Override
    public String createInvoice(Invoice invoice) {
        System.out.println("Usage of a Scanner");
        invoice = new Invoice();
        Customer customer = new Customer("Virgin Galatic");
        invoice.setCustomer(customer);
        invoiceService.createInvoice(invoice);

        return null;
    }
}
