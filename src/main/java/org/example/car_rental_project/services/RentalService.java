package org.example.car_rental_project.services;

import org.example.car_rental_project.models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {
    private List<Car> cars = new ArrayList<>();

    public RentalService() {
        var car1 = new Car("Benz", "E63", 2000);
        var car2 = new Car("BMW", "X6", 2500);
        var car3 = new Car("Nissan", "Patrol", 1500);
    }





}
