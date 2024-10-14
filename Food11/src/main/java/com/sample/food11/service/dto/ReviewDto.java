package com.sample.food11.service.dto;

import com.sample.food11.model.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Double avgScore;
    private List<ReviewEntity> reviews;
    private ReviewDtoPage page;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewDtoPage {
        private Integer offset;
        private Integer limit;

    }
}
