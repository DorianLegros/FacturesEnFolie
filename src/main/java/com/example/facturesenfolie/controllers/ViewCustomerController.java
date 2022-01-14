package com.example.facturesenfolie.controllers;

import com.example.facturesenfolie.models.Customer;
import com.example.facturesenfolie.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/view/customers")
public class ViewCustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/all")
    public String getAllCustomers(ModelMap model) {
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println(customers);

        if(customers != null)
            model.addAttribute("customers",customers);
        else
            model.addAttribute("customers", new ArrayList<Customer>());
        return "customer";
    }

    @GetMapping(value = "/byId/{id}")
    public String getCustomerById(@PathVariable Long id,ModelMap model) {
        Customer customer = customerService.getCustomerById(id);
        if(customer != null)
            model.addAttribute("customers",customer);
        else
            model.addAttribute("customers", new ArrayList<Customer>());
          return "customer";
    }

    @GetMapping(value = "/byFullName")
    public String findCustomersByFullName(@RequestParam (value = "fullName", defaultValue = "") String fullName,ModelMap model) {
        List<Customer> customers = customerService.searchCustomersByFullName(fullName);
        if(customers != null)
            model.addAttribute("customers",customers);
        else
            model.addAttribute("customers", new ArrayList<Customer>());
            return "customer";
    }

    @PostMapping("/add")
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer) {
        Customer customerCreated = customerService.createCustomer(customer);
        return new ResponseEntity<String>(customerCreated.toString(), HttpStatus.CREATED);
    }
}
