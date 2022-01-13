package com.example.facturesenfolie.repositories;

import com.example.facturesenfolie.models.ServiceInvoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceInvoiceRepository extends CrudRepository<ServiceInvoice, Long> {
    List<ServiceInvoice> findAll();
    Optional<ServiceInvoice> findById(Long id);
    List<ServiceInvoice> findByCustomerId(Long customerId);
}
