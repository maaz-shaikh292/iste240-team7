// Maaz Shaikh - 421007607
package org.example.car_rental_project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startDate", nullable = false)
    private String startDate;

    @Column(name = "endDate", nullable = false)
    private String endDate;

    @Column(name = "totalCost", nullable = false)
    private Double totalCost;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer linkedCustomer;

    public Booking() {}

    public Booking(String startDate, String endDate, Double totalCost, Boolean confirmed, Customer linkedCustomer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.confirmed = confirmed;
        this.linkedCustomer = linkedCustomer;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public Double getTotalCost() { return totalCost; }

    public void setTotalCost(Double totalCost) { this.totalCost = totalCost; }

    public Boolean getConfirmed() { return confirmed; }

    public void setConfirmed(Boolean confirmed) { this.confirmed = confirmed; }

    public Customer getLinkedCustomer() { return linkedCustomer; }

    public void setLinkedCustomer(Customer linkedCustomer) { this.linkedCustomer = linkedCustomer; }
}