package com.example.facturesenfolie.services;

import com.example.facturesenfolie.models.Customer;
import com.example.facturesenfolie.models.FormationInvoice;
import com.example.facturesenfolie.repositories.FormationInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FormationInvoiceService {
    @Autowired
    FormationInvoiceRepository repository;

    public List<FormationInvoice> getAllFormationInvoices() {
        List<FormationInvoice> formationInvoices = repository.findAll();
        if(!formationInvoices.isEmpty())
            return formationInvoices;
        else
            return null;
    }

    public FormationInvoice getFormationInvoiceById(Long id) {
        Optional<FormationInvoice> formationInvoice = repository.findById(id);
        return formationInvoice.orElse(null);
    }

    public List<FormationInvoice> searchFormationInvoicesByCustomerId(Long id) {
        List<FormationInvoice> formationInvoices = repository.findByCustomerId(id);
        if(!formationInvoices.isEmpty())
            return formationInvoices;
        else
            return null;
    }

    public FormationInvoice createFormationInvoice(FormationInvoice invoice) {
        return repository.save(invoice);
    }
}
