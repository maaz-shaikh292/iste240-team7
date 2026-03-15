//Alexander Ougnitch - 759002953

package org.example.car_rental_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SuccessMessageController {

    @GetMapping("/add/success/{type}")
    public String showSuccess(@PathVariable String type, Model model) {

        model.addAttribute("successMessage", "Success! " + type + " was added successfully!");
        return "success";
    }
}
