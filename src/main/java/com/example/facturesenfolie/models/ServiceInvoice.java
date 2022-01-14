package com.example.facturesenfolie.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

enum ServiceType {WEBSITE_MAKING, OTHER}

@Entity
public class ServiceInvoice implements IInvoice {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Customer customer;

    private float amount = 0;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sendDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate payDate;

    private PaymentMethod paymentMethod = PaymentMethod.TRANSFER;

    private InvoiceStatus status = InvoiceStatus.DRAFT;

    private String description = "";

    // specific properties
    private ServiceType type = ServiceType.OTHER;

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

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }
    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
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
                ", \"serviceType\":\"" + type + "\"" +
                '}';

        return result.replace("\"null\"", "null");
    }
}
