package com.stackroute.RecommendationService.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidOfFreelancer {

  private String freelancerEmailId ;
  private int proposedCompletionDate;
  private float bidAmount;
  private boolean projectAwarded;
}