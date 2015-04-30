package com.pierangeloc.shop.apis.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Currency;

/**
 * Created by pierangeloc on 26-4-15.
 */

public class Price {

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("currency")
    private Currency currency;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
