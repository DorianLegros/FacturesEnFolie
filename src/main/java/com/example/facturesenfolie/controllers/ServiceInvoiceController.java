package com.example.facturesenfolie.controllers;

import com.example.facturesenfolie.models.Customer;
import com.example.facturesenfolie.models.FormationInvoice;
import com.example.facturesenfolie.models.ServiceInvoice;
import com.example.facturesenfolie.services.CustomerService;
import com.example.facturesenfolie.services.FormationInvoiceService;
import com.example.facturesenfolie.services.ServiceInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/service-invoices")
public class ServiceInvoiceController {
    @Autowired
    ServiceInvoiceService serviceInvoiceService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<String> getAllServiceInvoices() {
        List<ServiceInvoice> invoices = serviceInvoiceService.getAllServiceInvoices();
        if(invoices != null)
            return new ResponseEntity<String>(invoices.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucun élément trouvé.", HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<String> getServiceInvoiceById(@PathVariable Long id) {
        ServiceInvoice invoice = serviceInvoiceService.getServiceInvoiceById(id);
        if(invoice != null)
            return new ResponseEntity<String>(invoice.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucune facture trouvée à cet ID.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byCustomerId/{id}")
    public ResponseEntity<String> findServiceInvoicesByCustomerId(@PathVariable Long id) {
        List<ServiceInvoice> invoices = serviceInvoiceService.searchServiceInvoicesByCustomerId(id);
        if(invoices != null)
            return new ResponseEntity<String>(invoices.toString(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("Aucun élément trouvé.", HttpStatus.OK);
    }

    @PostMapping("/add/{idCustomer}")
    public ResponseEntity<String> createServiceInvoice(@PathVariable Long idCustomer, @Valid @RequestBody ServiceInvoice invoice) {
        Customer customer = customerService.getCustomerById(idCustomer);
        if (customer == null)
            return new ResponseEntity<String>("Le client auquel vous souhaitez créer une facture n'existe pas.", HttpStatus.NOT_FOUND);
        invoice.setCustomer(customer);
        ServiceInvoice serviceInvoiceCreated = serviceInvoiceService.createFormationInvoice(invoice);
        return new ResponseEntity<String>(serviceInvoiceCreated.toString(), HttpStatus.CREATED);
    }
}
