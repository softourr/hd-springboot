package com.sample.food11.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sample.food11.model.QReviewEntity;
import com.sample.food11.model.ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public Slice<ReviewEntity> findSliceByFoodId(Long foodId, Pageable page) {
        List<ReviewEntity> reviews = queryFactory.select(QReviewEntity.reviewEntity)
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.foodId.eq(foodId))
                .offset((long)page.getPageNumber() * page.getPageSize()) // 0 page * 10pageSize
                .limit(page.getPageSize()+1)
                .fetch();
        return new SliceImpl<>(reviews.stream().limit(page.getPageSize()).toList(),
                page,
                reviews.size() > page.getPageSize()
        );
    }
}
