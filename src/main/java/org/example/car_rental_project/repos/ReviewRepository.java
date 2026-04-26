package org.example.car_rental_project.repos;

import org.example.car_rental_project.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review,Long> {


    @Modifying
    @Query("update Review r set r.rating = :rating where r.id = :id")
    int updateRatingById(@Param("rating") Long id, @Param("rating") Integer rating);

}
