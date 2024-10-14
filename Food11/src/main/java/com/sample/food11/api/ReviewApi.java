package com.sample.food11.api;

import com.sample.food11.api.request.CreateReviewRequest;
import com.sample.food11.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewApi {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<String> createReview(
            @RequestBody CreateReviewRequest request
    ){
        reviewService.createReview(request.getFoodId(), request.getContent(),
                request.getScore());

        return ResponseEntity.
                status(HttpStatus.CREATED).body("success");
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long reviewId){
        reviewService.deleteReview(reviewId);
    }
}
