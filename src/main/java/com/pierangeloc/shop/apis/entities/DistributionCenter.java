package com.pierangeloc.shop.apis.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pierangeloc on 26-4-15.
 */
public class DistributionCenter {

    @JsonProperty("distributionCenter")
    private String id;
    private String description;
    private String location;

    @JsonProperty("availability")
    private List<Stock> availability;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Stock> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Stock> availability) {
        this.availability = availability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
