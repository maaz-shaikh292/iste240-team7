// Amir Faraji, UID-754006884
// Maaz Shaikh, UID-421007607
// Alexander Ougnitch, UID-759002953

package org.example.car_rental_project.controllers;
import org.example.car_rental_project.models.Booking;
import org.example.car_rental_project.models.Car;
import org.example.car_rental_project.models.Customer;
import org.example.car_rental_project.models.Review;
import org.example.car_rental_project.services.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final RentalService rentalService;

    public MainController (RentalService rentalService){
        this.rentalService=rentalService;
    }

    //maaz
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

    // Alexander
    @GetMapping("/reviews")
    public String showReviews(Model model) {
        model.addAttribute("reviews", rentalService.getAllReviews());
        return "reviews-list";
    }

    @GetMapping("/reviews/add")
    public String showAddReviewsForm() {
        return "reviews-form";
    }

    @PostMapping("/review/add")
    public String addReview(Review review) {
        rentalService.addReview(review);
        return "redirect:/add/success/review";
    }

    //Amir
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

    // sucess message redirecrtion mapping
    @GetMapping("/add/success/{type}")
    public String showSuccess(@PathVariable String type, Model model) {

        model.addAttribute("successMessage", "Success! " + type + " was added successfully!");
        return "success";
    }


}
