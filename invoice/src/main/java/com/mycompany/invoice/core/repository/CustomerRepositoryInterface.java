package com.mycompany.invoice.core.repository;

import com.mycompany.invoice.core.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositoryInterface extends CrudRepository<Customer, Long> {}
