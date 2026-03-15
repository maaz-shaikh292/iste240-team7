package org.example.car_rental_project.controllers;

// Maaz Shaikh, UID-421007607

import org.example.car_rental_project.models.Booking;
import org.example.car_rental_project.models.Customer;
import org.example.car_rental_project.services.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerBookingController {

    private final RentalService rentalService;

    public CustomerBookingController(RentalService rentalService) {
        this.rentalService = rentalService;
    }


    @GetMapping("/customers")
    public String showCustomers(Model model) {
        model.addAttribute("customers", rentalService.getAllCustomers());
        return "customer-list";
    }

    @GetMapping("/customers/add")
    public String showAddCustomerForm() {
        return "customer-form";
    }

    @PostMapping("/customers/add")
    public String addCustomer(Customer customer) {
        rentalService.addCustomer(customer);
        return "redirect:/add/success/customer";
    }

    @GetMapping("/bookings")
    public String showBookings(Model model) {
        model.addAttribute("bookings", rentalService.getAllBookings());
        return "booking-list";
    }

    @GetMapping("/bookings/add")
    public String showAddBookingForm(Model model) {
        model.addAttribute("customers", rentalService.getAllCustomers());
        return "booking-form";
    }

    @PostMapping("/bookings/add")
    public String addBooking(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam Double totalCost,
            @RequestParam(defaultValue = "false") Boolean confirmed,
            @RequestParam String customerUsername) {

        Customer linkedCustomer = rentalService.getCustomerByUsername(customerUsername);

        Booking newBooking = new Booking(startDate, endDate, totalCost, confirmed, linkedCustomer);

        rentalService.addBooking(newBooking);
        return "redirect:/add/success/booking";
    }


}
