package com.example.facturesenfolie.repositories;

import com.example.facturesenfolie.models.ServiceInvoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceInvoiceRepository extends CrudRepository<ServiceInvoice, Long> {
    List<ServiceInvoice> findAll();
    Optional<ServiceInvoice> findById(Long id);
    List<ServiceInvoice> findByCustomerId(Long customerId);
}
