// Maaz Shaikh - 421007607
package org.example.car_rental_project.repositories;

import org.example.car_rental_project.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByUsername(String username);

    @Query("SELECT c FROM Customer c WHERE LOWER(c.username) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Customer> searchByUsername(@Param("keyword") String keyword);

    @Modifying
    @Query("UPDATE Customer c SET c.email = :email WHERE c.id = :id")
    int updateEmailById(@Param("id") Long id, @Param("email") String email);


}