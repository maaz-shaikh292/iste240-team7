package org.example.car_rental_project.controllers;

import org.example.car_rental_project.models.Review;
import org.example.car_rental_project.services.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerReviewsController {

    private final RentalService rentalService;
    public CustomerReviewsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }


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


}
