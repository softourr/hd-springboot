package com.sample.food11.service;

import com.sample.food11.model.ReviewEntity;
import com.sample.food11.repository.FoodRepository;
import com.sample.food11.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class ReviewService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Transactional
    public void createReview(Long foodId, String content, Double score){
        foodRepository.findById(foodId).orElseThrow();

        ReviewEntity review = ReviewEntity.builder()
                .foodId(foodId)
                .content(content)
                .score(score)
                .createdAt(ZonedDateTime.now())
                .build();
        reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId){
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();
        reviewRepository.delete(review);
    }
}
