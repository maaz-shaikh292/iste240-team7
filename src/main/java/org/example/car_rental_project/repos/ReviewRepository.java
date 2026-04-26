package org.example.car_rental_project.repos;

import org.example.car_rental_project.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {


    @Modifying
    @Query("UPDATE Review r SET r.rating = :rating WHERE r.id = :id")
    int updateRatingById(@Param("id") Long id, @Param("rating") Integer rating);

    @Query("SELECT r FROM Review r WHERE r.rating = :rating")
    List<Review> findByRating(@Param("rating") Integer rating);

}
