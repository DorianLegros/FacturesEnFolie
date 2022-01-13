package com.example.facturesenfolie.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

enum InvoiceStatus { DRAFT, NOT_PAID, PAID }

public interface IInvoice {
    Long id = null;
    Long customerId = null;
    float amount = 0;
    Date sendDate = new Date();
    Date payDate = new Date();
    InvoiceStatus status = InvoiceStatus.DRAFT;
    String description = "";
}
