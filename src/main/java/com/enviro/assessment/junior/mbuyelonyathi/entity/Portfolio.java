package com.enviro.assessment.junior.mbuyelonyathi.entity;

import jakarta.persistence.*;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Double balance;

    @ManyToOne
    private Investor investor;

    public Portfolio() {
    }

    public Portfolio(Long id, String productName,
                     Double balance, Investor investor) {
        this.id = id;
        this.productName = productName;
        this.balance = balance;
        this.investor = investor;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getBalance() {
        return balance;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}