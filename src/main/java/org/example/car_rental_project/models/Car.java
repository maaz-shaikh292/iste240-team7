// Amir Faraji - 754006884
package org.example.car_rental_project.models;

import jakarta.persistence.*;
//import org.springframework.stereotype.Component;

@Entity
@Table(name="Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column ( name = "Brand", length = 70, nullable = false)
    private String brand;

    @Column (name = "Model", length = 15, nullable = false)
    private String model;

    @Column (name = "Price", nullable = false)
    private Integer price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car (){
    };

    public Car(String brand, String model, Integer price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
}
