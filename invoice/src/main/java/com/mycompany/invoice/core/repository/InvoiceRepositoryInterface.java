package com.mycompany.invoice.core.repository;

import com.mycompany.invoice.core.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {
    @Query("SELECT invoice from Invoice invoice inner join fetch invoice.customer")
    Iterable<Invoice> findAll();
    /*Invoice create(Invoice invoice);
    List<Invoice> list();
    Invoice getById(String number);*/
}
