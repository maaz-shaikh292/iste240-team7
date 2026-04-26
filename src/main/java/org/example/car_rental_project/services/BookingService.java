// Maaz Shaikh - 421007607
package org.example.car_rental_project.services;

import org.example.car_rental_project.models.Booking;
import org.example.car_rental_project.repos.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> findByCustomerUsername(String username) {
        return bookingRepository.findByCustomerUsername(username);
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Transactional
    public void updateConfirmed(Long id, Boolean confirmed) {
        bookingRepository.updateConfirmedById(id, confirmed);
    }

    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }
}