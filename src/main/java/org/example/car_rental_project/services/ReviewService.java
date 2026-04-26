package org.example.car_rental_project.services;

import org.example.car_rental_project.models.Review;
import org.example.car_rental_project.repos.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;

    }

    public List<Review> getAllReviews()
    {
        return reviewRepository.findAll();
    }

    public List<Review> findByRating(Integer rating)
    {
        return reviewRepository.findByRating(rating);
    }

    public Review saveReview(Review review)
    {
        return reviewRepository.save(review);
    }

    @Transactional
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Transactional
    public Review updateReview(Review review)
    {
        return reviewRepository.save(review);
    }

}
