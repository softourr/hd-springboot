package com.sample.food11.repository;

import com.sample.food11.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, ReviewRepositoryCustom {
    @Query("select avg(r.score) from ReviewEntity r where r.foodId = :foodId")
    Double getAvgScoreByFoodId(@Param("foodId") Long foodId);
}
