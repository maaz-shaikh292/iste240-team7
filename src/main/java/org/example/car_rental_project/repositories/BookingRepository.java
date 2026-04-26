// Maaz Shaikh - 421007607
package org.example.car_rental_project.repositories;

import org.example.car_rental_project.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByConfirmed(Boolean confirmed);

    @Query("SELECT b FROM Booking b WHERE b.linkedCustomer.username = :username")
    List<Booking> findByCustomerUsername(@Param("username") String username);

    @Modifying
    @Query("UPDATE Booking b SET b.confirmed = :confirmed WHERE b.id = :id")
    int updateConfirmedById(@Param("id") Long id, @Param("confirmed") Boolean confirmed);

}
