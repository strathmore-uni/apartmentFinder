package com.apartmentFinder.components.utils;

// Class to represent a Unit with its details
public class Unit {
    private String locationDescription;
    private String bedrooms;
    private String bathrooms;
    private String sqft;
    private String unitId;
    private String apartmentId;
    private String price;

    public Unit(String locationDescription, String bedrooms, String bathrooms, String sqft, String unitId, String apartmentId, String price) {
        this.locationDescription = locationDescription;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sqft = sqft;
        this.unitId = unitId;
        this.apartmentId = apartmentId;
        this.price = price;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}