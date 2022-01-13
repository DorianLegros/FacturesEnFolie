package com.example.facturesenfolie.repositories;

import com.example.facturesenfolie.models.FormationInvoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormationInvoiceRepository extends CrudRepository<FormationInvoice, Long> {
    List<FormationInvoice> findAll();
    Optional<FormationInvoice> findById(Long id);
    List<FormationInvoice> findByCustomerId(Long customerId);
}
