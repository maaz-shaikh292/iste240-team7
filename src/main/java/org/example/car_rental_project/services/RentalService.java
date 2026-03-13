package org.example.car_rental_project.services;

// Maaz Shaikh, UID-421007607

import org.example.car_rental_project.models.Booking;
import org.example.car_rental_project.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {

    private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public RentalService() {

        Customer sampleCustomer = new Customer("maaz_user", "ritabc123", "mas9236@rit.edu", "123456");
        customers.add(sampleCustomer);

        Booking sampleBooking = new Booking("2026-03-15", "2026-03-20", 550.00, true, sampleCustomer);
        bookings.add(sampleBooking);
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
