package org.example.car_rental_project.models;

import org.springframework.stereotype.Component;

@Component
public class Booking {

    private String startDate;
    private String endDate;
    private double totalCost;
    private boolean confirmed;


    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public double getTotalCost() { return totalCost; }

    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public boolean getConfirmed() { return confirmed; }

    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
}