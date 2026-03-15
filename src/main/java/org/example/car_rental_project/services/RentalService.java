package org.example.car_rental_project.services;

// Maaz Shaikh, UID-421007607

// Amir Faraji, UID-754006884

import org.example.car_rental_project.models.Booking;
import org.example.car_rental_project.models.Car;
import org.example.car_rental_project.models.Customer;
import org.example.car_rental_project.models.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {

    private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();





    public RentalService() {
        // Amir - Added the services required for sample data for cars
        var car1 = new Car("Benz", "E63", 2000);
        var car2 = new Car("BMW", "X6", 2500);
        cars.add(car1);
        cars.add(car2);

        Customer sampleCustomer = new Customer("maaz_user", "ritabc123", "mas9236@rit.edu", "123456");
        customers.add(sampleCustomer);

        Booking sampleBooking = new Booking("2026-03-15", "2026-03-20", 550.00, true, sampleCustomer);
        bookings.add(sampleBooking);

        Review demoReview = new Review( 5 , "it was a great experience");
        reviews.add(demoReview);
    }

    public List<Review> getAllReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    // Amir - Listing all the cars
    public List<Car> getAllCars(){
        return cars;
    }

    // Amir - Adding a car
    public void addCar(Car car){
        cars.add(car);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomerByUsername(String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }



    public List<Booking> getAllBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}
