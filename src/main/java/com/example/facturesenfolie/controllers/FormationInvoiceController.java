package com.example.facturesenfolie.controllers;

import com.example.facturesenfolie.models.Customer;
import com.example.facturesenfolie.models.FormationInvoice;
import com.example.facturesenfolie.services.CustomerService;
import com.example.facturesenfolie.services.FormationInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/formation-invoices")
public class FormationInvoiceController {
    @Autowired
    FormationInvoiceService formationInvoiceService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<String> getAllFormationInvoices() {
        List<FormationInvoice> invoices = formationInvoiceService.getAllFormationInvoices();
        if(invoices != null)
            return new ResponseEntity<String>(invoices.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucun élément trouvé.", HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<String> getFormationInvoiceById(@PathVariable Long id) {
        FormationInvoice invoice = formationInvoiceService.getFormationInvoiceById(id);
        if(invoice != null)
            return new ResponseEntity<String>(invoice.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucune facture trouvée à cet ID.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byCustomerId/{id}")
    public ResponseEntity<String> findCustomersByFullName(@PathVariable Long id) {
        List<FormationInvoice> invoices = formationInvoiceService.searchFormationInvoicesByCustomerId(id);
        if(invoices != null)
            return new ResponseEntity<String>(invoices.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucun élément trouvé.", HttpStatus.OK);
    }

    @PostMapping("/add/{idCustomer}")
    public ResponseEntity<String> createCustomer(@PathVariable Long idCustomer, @Valid @RequestBody FormationInvoice invoice) {
        Customer customer = customerService.getCustomerById(idCustomer);
        if (customer == null)
            return new ResponseEntity<String>("Le client auquel vous souhaitez créer une facture n'existe pas.", HttpStatus.NOT_FOUND);
        invoice.setCustomer(customer);
        FormationInvoice formationInvoiceCreated = formationInvoiceService.createFormationInvoice(invoice);
        return new ResponseEntity<String>(formationInvoiceCreated.toString(), HttpStatus.CREATED);
    }
}
