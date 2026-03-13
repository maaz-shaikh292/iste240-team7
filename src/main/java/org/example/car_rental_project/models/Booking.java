package org.example.car_rental_project.models;

//Maaz Shaikh, UID-421007607

public class Booking {

    private String startDate;
    private String endDate;
    private Double totalCost;
    private Boolean confirmed;

    private Customer customer;

    public Booking(String startDate, String endDate, Double totalCost, Boolean confirmed, Customer customer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.confirmed = confirmed;
        this.customer = customer;
    }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public Double getTotalCost() { return totalCost; }

    public void setTotalCost(Double totalCost) { this.totalCost = totalCost; }

    public Boolean getConfirmed() { return confirmed; }

    public void setConfirmed(Boolean confirmed) { this.confirmed = confirmed; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }
}