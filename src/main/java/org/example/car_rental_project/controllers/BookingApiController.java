// Maaz Shaikh - 421007607
package org.example.car_rental_project.controllers;

import org.example.car_rental_project.models.Booking;
import org.example.car_rental_project.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingApiController {

    private final BookingService bookingService;

    public BookingApiController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping
    public ResponseEntity<List<Booking>> getAll() {
        return ResponseEntity.ok(bookingService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Booking> getById(@PathVariable Long id) {
        Booking b = bookingService.findById(id);
        if (b == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(b);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Booking>> search(@RequestParam String username) {
        return ResponseEntity.ok(bookingService.findByCustomerUsername(username));
    }


    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(booking));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Booking> update(@PathVariable Long id, @RequestBody Booking booking) {
        booking.setId(id);
        return ResponseEntity.ok(bookingService.save(booking));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}