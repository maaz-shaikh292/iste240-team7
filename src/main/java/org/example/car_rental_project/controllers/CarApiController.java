// Amir Faraji - 754006884
package org.example.car_rental_project.controllers;

import org.example.car_rental_project.models.Car;
import org.example.car_rental_project.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

@RequestMapping("/api/cars")
public class CarApiController {

    private final CarService carService;

    public CarApiController(CarService carService) {
        this.carService = carService;
    }

    // GET all cars
    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    // GET one car by id
    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id) {
        Car car = carService.findById(id);
        if (car == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(car);
    }

    // GET search by brand keyword
    @GetMapping("/search")
    public ResponseEntity<List<Car>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(carService.searchByBrand(keyword));
    }

    // POST create new car
    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        if (car.getPrice() == null || car.getPrice() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(car));
    }


    // PUT full update
    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car car) {
        if (car.getPrice() == null || car.getPrice() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        car.setId(id);
        return ResponseEntity.ok(carService.save(car));
    }

    // PUT update price only
    @PutMapping("/{id}/price")
    public ResponseEntity<Void> updatePrice(@PathVariable Long id, @RequestParam Integer price) {
        if (price == null || price < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        carService.updatePrice(id, price);
        return ResponseEntity.ok().build();
    }

    // DELETE car by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}