package com.apartmentFinder.components.utils;


import com.apartmentFinder.landlordDashboard.LandlordDashboard;

public class LandlordDashboardData {
    private String userName;
    private String userPrice;
    private String userBedroom;
    private String userBathroom;
    private String userSqft;
    private  String userNumber;
    private  String apartmentname;
    private  String apartmentid;


    public LandlordDashboardData(String name,String apartmentid,String apartmentname, String price, String bedroom, String bathroom, String sqft,String phone){

        this.userName=name;
        this.apartmentid=apartmentid;
        this.apartmentname=apartmentname;
        this.userPrice=price;
        this.userBedroom=bedroom;
        this.userBathroom=bathroom;
        this.userSqft=sqft;
        this.userNumber=phone;
    }
   public LandlordDashboardData(){}

    public String getUserNumber(){
        return userNumber;
    }
    public String getUserName(){
        return userName;
    }
    public String getApartmentid(){return apartmentid;}
    public String getApartmentname(){return apartmentname;}
    public String getUserPrice(){
        return userPrice;
    }
    public String getUserBedroom(){
        return userBedroom;
    }
    public String getUserBathroom(){
        return userBathroom;
    }
    public String getUserSqft(){
        return userSqft;
    }
}
