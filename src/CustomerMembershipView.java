/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerMembershipView {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate createdDate;
    private String membershipType;
    private BigDecimal discountPercent;

    public CustomerMembershipView(int customerId, String firstName, String lastName, String email,
                                  String phone, LocalDate createdDate, String membershipType,
                                  BigDecimal discountPercent) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.createdDate = createdDate;
        this.membershipType = membershipType;
        this.discountPercent = discountPercent;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }
}