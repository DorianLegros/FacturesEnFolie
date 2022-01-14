package com.example.facturesenfolie.controllers;

import com.example.facturesenfolie.models.Customer;
import com.example.facturesenfolie.models.FormationInvoice;
import com.example.facturesenfolie.models.ServiceInvoice;
import com.example.facturesenfolie.services.CustomerService;
import com.example.facturesenfolie.services.FormationInvoiceService;
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
@RequestMapping("/view/formation-invoices")
public class ViewFormationInvoiceController {
    @Autowired
    FormationInvoiceService formationInvoiceService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public String getAllFormationInvoices(ModelMap model) {
        List<FormationInvoice> invoices = formationInvoiceService.getAllFormationInvoices();
        if (invoices != null)
            model.addAttribute("formationInvoices", invoices);
        else
            model.addAttribute("formationInvoices", new ArrayList<FormationInvoice>());
        return "invoice";
    }

    @GetMapping("/byId/{id}")
    public String getFormationInvoiceById(@PathVariable Long id, ModelMap model) {
        FormationInvoice invoice = formationInvoiceService.getFormationInvoiceById(id);
        if (invoice != null)
            model.addAttribute("formationInvoices", invoice);
        else
            model.addAttribute("formationInvoices", new ArrayList<FormationInvoice>());
        return "invoice";
    }

    @GetMapping("/byCustomerId/{id}")
    public String findCustomersByFullName(@PathVariable Long id, ModelMap model) {
        List<FormationInvoice> invoices = formationInvoiceService.searchFormationInvoicesByCustomerId(id);
        if (invoices != null)
            model.addAttribute("formationInvoices", invoices);
        else
            model.addAttribute("formationInvoices", new ArrayList<FormationInvoice>());
        return "invoice";
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

    @GetMapping(value = "/formInvoice")
    public String displayFormInvoice(ModelMap model) {
        model.addAttribute("invoice", new FormationInvoice());
        return "formInvoice";
    }
}
