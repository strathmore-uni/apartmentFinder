package com.apartmentFinder.components.utils;

// Class to represent a Unit with its details
public class Unit {
    private String locationDescription;
    private String bedrooms;
    private String bathrooms;
    private String sqft;
    private int unitId;
    private int apartmentId;
    private String price;

    public Unit(String locationDescription, String bedrooms, String bathrooms, String sqft, String unitId, String apartmentId, String price) {
        this.locationDescription = locationDescription;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sqft = sqft;
        this.unitId = Integer.parseInt(unitId);
        this.apartmentId = Integer.parseInt(apartmentId);
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

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}