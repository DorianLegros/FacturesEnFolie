package com.example.facturesenfolie.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String firstName;

    @Column(nullable = false)
    @NotBlank
    private String lastName;

    private String fullName = this.firstName + " " + this.lastName;

    @Column(nullable = false)
    @NotBlank
    private String email;

    private String phone;

    private String mobile;

    private String address1;

    private String address2;

    private String zipCode;

    private String city;

    private String state;

    private String country;

    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.fullName = this.firstName + " " + this.lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.fullName = this.firstName + " " + this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        String result = "{" +
                "\"id\": " + id +
                ", \"firstName\":\"" + firstName + "\"" +
                ", \"lastName\":\"" + lastName + "\"" +
                ", \"fullName\":\"" + fullName + "\"" +
                ", \"email\":\"" + email + "\"" +
                ", \"phone\":\"" + phone + "\"" +
                ", \"mobile\":\"" + mobile + "\"" +
                ", \"address1\":\"" + address1 + "\"" +
                ", \"address2\":\"" + address2 + "\"" +
                ", \"zipCode\":\"" + zipCode + "\"" +
                ", \"city\":\"" + city + "\"" +
                ", \"state\":\"" + state + "\"" +
                ", \"country\":\"" + country + "\"" +
                ", \"notes\":\"" + notes + "\"" +
                "}";

        return result.replace("\"null\"", "null");
    }
}
