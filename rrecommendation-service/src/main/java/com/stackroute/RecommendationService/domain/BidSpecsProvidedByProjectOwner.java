package com.stackroute.RecommendationService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidSpecsProvidedByProjectOwner {

    private Double maximumBudget;
    private Double minimumBudget;
    private String bidLastDate;
}