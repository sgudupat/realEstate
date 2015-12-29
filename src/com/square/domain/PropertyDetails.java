package com.square.domain;

public class PropertyDetails {
    String buyerName;
    String buyerMobile;
    String Apartment;

    public PropertyDetails(String pN, String pM, String pA) {
        this.buyerName = pN;
        this.buyerMobile = pM;
        this.Apartment = pA;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(String buyerMobile) {
        this.buyerMobile = buyerMobile;
    }

    public String getApartment() {
        return Apartment;
    }

    public void setApartment(String apartment) {
        Apartment = apartment;
    }

    @Override
    public String toString() {
        return "propertyDetails [buyerName=" + buyerName + ", buyerMobile="
                + buyerMobile + ", Apartment=" + Apartment + "]";
    }
}
