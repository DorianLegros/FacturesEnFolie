package com.example.facturesenfolie.repositories;

import com.example.facturesenfolie.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    List<Customer> findCustomerByFullNameContains(String fullName);
    List<Customer> findCustomerByEmail(String email);
}
