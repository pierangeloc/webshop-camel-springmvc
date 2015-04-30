package com.pierangeloc.shop.apis.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pierangeloc on 26-4-15.
 */
public class Stock {
    @JsonProperty("sku")
    private String sku = "";
    @JsonProperty("items")
    private int items = 0;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }
}
