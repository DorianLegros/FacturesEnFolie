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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/view/service-invoices")
public class ViewServiceInvoiceController {
    @Autowired
    ServiceInvoiceService serviceInvoiceService;
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/all")
    public String getAllServiceInvoices(ModelMap model) {
        List<ServiceInvoice> invoices = serviceInvoiceService.getAllServiceInvoices();
        if (invoices != null)
            model.addAttribute("serviceInvoices", invoices);
        else
            model.addAttribute("serviceInvoices", new ArrayList<ServiceInvoice>());
        return "invoice";
    }

    @GetMapping(value = "/byId/{id}")
    public String getServiceInvoiceById(@PathVariable Long id, ModelMap model) {
        ServiceInvoice invoice = serviceInvoiceService.getServiceInvoiceById(id);
        if (invoice != null)
            model.addAttribute("serviceInvoices", invoice);
        else
            model.addAttribute("serviceInvoices", new ArrayList<ServiceInvoice>());
        return "invoice";
    }

    @GetMapping(value = "/byCustomerId/{id}")
    public String findServiceInvoicesByCustomerId(@PathVariable Long id, ModelMap model) {
        List<ServiceInvoice> invoices = serviceInvoiceService.searchServiceInvoicesByCustomerId(id);
        if (invoices != null)
            model.addAttribute("serviceInvoices", invoices);
        else
            model.addAttribute("serviceInvoices", new ArrayList<ServiceInvoice>());
        return "invoice";
    }

    @PostMapping(value = "/add/{idCustomer}")
    public ResponseEntity<String> createServiceInvoice(@PathVariable Long idCustomer, @ModelAttribute ServiceInvoice invoice) {
        Customer customer = customerService.getCustomerById(idCustomer);
        if (customer == null)
            return new ResponseEntity<String>("Le client auquel vous souhaitez créer une facture n'existe pas.", HttpStatus.NOT_FOUND);
        invoice.setCustomer(customer);
        ServiceInvoice serviceInvoiceCreated = serviceInvoiceService.createFormationInvoice(invoice);

        return new ResponseEntity<String>(serviceInvoiceCreated.toString(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/formInvoice")
    public String displayFormInvoice(ModelMap model) {
        model.addAttribute("invoice", new ServiceInvoice());
        return "formInvoice";
    }
}
