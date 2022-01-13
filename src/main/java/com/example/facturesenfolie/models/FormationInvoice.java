package com.example.facturesenfolie.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FormationInvoice implements IInvoice {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Customer customer;

    private float amount = 0;

    private Date sendDate = new Date();

    private Date payDate = new Date();

    private PaymentMethod paymentMethod = PaymentMethod.TRANSFER;

    private InvoiceStatus status = InvoiceStatus.DRAFT;

    private String description = "";

    // specific properties
    private long candidateNumber = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(long candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    @Override
    public String toString() {
        String result = "{" +
                "\"id\":\"" + id + "\"" +
                ", \"customer\": " + customer +
                ", \"amount\":" + amount +
                ", \"sendDate\":\"" + sendDate + "\"" +
                ", \"payDate\":\"" + payDate + "\"" +
                ", \"paymentMethod\":\"" + paymentMethod + "\"" +
                ", \"status\":\"" + status + "\"" +
                ", \"description\":\"" + description + "\"" +
                ", \"candidateNumber\":" + candidateNumber +
                '}';

        return result.replace("\"null\"", "null");
    }
}
