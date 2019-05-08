package com.stackroute.ProjectDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidSpecsProvidedByProjectOwner{

    private Double maximumBudget;
    private Double minimumBudget;
    private String bidLastDate;
}