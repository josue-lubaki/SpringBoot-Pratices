package com.mycompany.invoice.core.service.number;

import com.mycompany.invoice.core.entity.Invoice;
import com.mycompany.invoice.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoice.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    private static long lastNumber = 0L;

    @Autowired
    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * Methode qui permet de créer une facture
     * @returns void
     * */
    public Invoice createInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
//        if(OptionalInvoice.isEmpty()){
//            throw new NoSuchElementException();
//        }
//
//        Invoice invoice = OptionalInvoice.get();
//        // Initialize proxy
//        invoice.getCustomer().getName();
//        return invoice;
    }

}
