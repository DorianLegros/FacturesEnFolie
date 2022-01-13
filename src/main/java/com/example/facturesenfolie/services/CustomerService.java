package com.example.facturesenfolie.services;

import com.example.facturesenfolie.models.Customer;
import com.example.facturesenfolie.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component("CustomerService")
@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = repository.findAll();
        if(!customers.isEmpty())
            return customers;
        else
            return null;
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = repository.findById(id);
        return customer.orElse(null);
    }

    public List<Customer> searchCustomerByFullName(String fullName) {
        List<Customer> customers = repository.findCustomerByFullNameContains(fullName);
        if(!customers.isEmpty())
            return customers;
        else
            return null;
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }
}
