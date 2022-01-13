package com.example.facturesenfolie.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class FormationInvoice implements IInvoice {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long customerId;

    @Column
    private float amount = 0;

    @Column
    private Date sendDate = new Date();

    @Column
    private Date payDate = new Date();

    @Column
    private InvoiceStatus status = InvoiceStatus.DRAFT;

    @Column
    private String description = "";

    // specific properties
    @Column
    private long candidateNumber = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
}
