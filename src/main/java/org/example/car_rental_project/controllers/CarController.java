package org.example.car_rental_project.controllers;

import org.example.car_rental_project.models.Car;
import org.example.car_rental_project.services.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    private RentalService rentalService;

    public CarController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping("/cars")
    public String showCarsRentals(Model model){
        model.addAttribute("cars", rentalService.getAllCars());
        return "car_rentals";
    }

    @GetMapping("/cars/add")
    public  String showCarForm(){
        return "car_form";
    }

    @PostMapping("/cars/add")
    public String addCar( Car car){
        rentalService.addCar(car);
        return "redirect:/cars";
    }








}
