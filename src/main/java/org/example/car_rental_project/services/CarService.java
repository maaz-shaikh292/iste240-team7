// Amir Faraji - 754006884
package org.example.car_rental_project.services;

import org.example.car_rental_project.models.Car;
import org.example.car_rental_project.repos.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;


        if (carRepository.count() == 0) {
            carRepository.save(new Car("Mercedes", "E63", 2000));
            carRepository.save(new Car("BMW", "X6", 2500));
            carRepository.save(new Car("Audi", "A7", 1800));
            carRepository.save(new Car("Ferrari", "488", 5000));
            carRepository.save(new Car("Porsche", "911", 3500));
            carRepository.save(new Car("Lamborghini", "Huracan", 6000));
        }
    }


    // get all cars
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    // get one car by id
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    // find by brand exact
    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    // search by keyword partial
    public List<Car> searchByBrand(String keyword) {
        return carRepository.searchByBrand(keyword);
    }

    // save new or updated car
    public Car save(Car car) {
        return carRepository.save(car);
    }

    // update price

    public void updatePrice(Long id, Integer price) {
        carRepository.updatePriceById(id, price);
    }

    // delete by id
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}