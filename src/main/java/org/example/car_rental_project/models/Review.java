package org.example.car_rental_project.models;

import org.springframework.stereotype.Component;


public class Review {

    private Integer rating;
    private String description;

    public Review(Integer rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
