package com.example.facturesenfolie.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

enum InvoiceStatus { DRAFT, NOT_PAID, PAID }
enum PaymentMethod { BANK_CHECK, TRANSFER, BANK_CARD, CASH }

public interface IInvoice {
    Long id = null;
    Long customerId = null;
    Customer customer = null;
    float amount = 0;
    Date sendDate = new Date();
    Date payDate = new Date();
    PaymentMethod paymentMethod = PaymentMethod.TRANSFER;
    InvoiceStatus status = InvoiceStatus.DRAFT;
    String description = "";
}
