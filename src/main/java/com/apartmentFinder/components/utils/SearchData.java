package com.apartmentFinder.components.utils;
public class SearchData {
    private String location;
    private String minPrice;
    private String maxPrice;

    // Constructors, getters, and setters
    public SearchData(String location, String minPrice, String maxPrice) {
        this.location = location;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }
}
