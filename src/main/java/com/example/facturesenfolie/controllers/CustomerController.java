package com.example.facturesenfolie.controllers;

import com.example.facturesenfolie.models.Customer;
import com.example.facturesenfolie.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<String> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if(customers != null)
            return new ResponseEntity<String>(customers.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucun élément trouvé.", HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<String> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if(customer != null)
            return new ResponseEntity<String>(customer.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucun client trouvé à cet ID.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byFullName")
    public ResponseEntity<String> findCustomersByFullName(@RequestParam (value = "fullName", defaultValue = "") String fullName) {
        List<Customer> customers = customerService.searchCustomerByFullName(fullName);
        if(customers != null)
            return new ResponseEntity<String>(customers.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucun élément trouvé.", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer) {
        Customer customerCreated = customerService.createCustomer(customer);
        return new ResponseEntity<String>(customerCreated.toString(), HttpStatus.CREATED);
    }
}
