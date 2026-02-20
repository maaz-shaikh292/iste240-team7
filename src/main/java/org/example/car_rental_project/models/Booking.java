package org.example.car_rental_project.models;

import org.springframework.stereotype.Component;

@Component
public class Booking {

    private String startDate;
    private String endDate;
    private Double totalCost;
    private Boolean confirmed;


    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public Double getTotalCost() { return totalCost; }

    public void setTotalCost(Double totalCost) { this.totalCost = totalCost; }

    public Boolean getConfirmed() { return confirmed; }

    public void setConfirmed(Boolean confirmed) { this.confirmed = confirmed; }
}