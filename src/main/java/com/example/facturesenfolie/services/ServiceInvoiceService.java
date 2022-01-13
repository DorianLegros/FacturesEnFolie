package com.example.facturesenfolie.services;

import com.example.facturesenfolie.models.FormationInvoice;
import com.example.facturesenfolie.models.ServiceInvoice;
import com.example.facturesenfolie.repositories.FormationInvoiceRepository;
import com.example.facturesenfolie.repositories.ServiceInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceInvoiceService {
    @Autowired
    ServiceInvoiceRepository repository;

    public List<ServiceInvoice> getAllServiceInvoices() {
        List<ServiceInvoice> serviceInvoices = repository.findAll();
        if(!serviceInvoices.isEmpty())
            return serviceInvoices;
        else
            return null;
    }

    public ServiceInvoice getServiceInvoiceById(Long id) {
        Optional<ServiceInvoice> serviceInvoice = repository.findById(id);
        return serviceInvoice.orElse(null);
    }

    public List<ServiceInvoice> searchServiceInvoicesByCustomerId(Long id) {
        List<ServiceInvoice> serviceInvoices = repository.findByCustomerId(id);
        if(!serviceInvoices.isEmpty())
            return serviceInvoices;
        else
            return null;
    }
}
