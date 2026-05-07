/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

public class Membership {
    private int membershipId;
    private String membershipType;
    private BigDecimal discountPercent;

    public Membership() {
    }

    public Membership(int membershipId, String membershipType, BigDecimal discountPercent) {
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.discountPercent = discountPercent;
    }

    public Membership(String membershipType, BigDecimal discountPercent) {
        this.membershipType = membershipType;
        this.discountPercent = discountPercent;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return membershipType;
    }
}