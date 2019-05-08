package com.stackroute.freelancerprofile.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class BidKafka {
    private String projectId;
    private String projectName;
    private String projectOwnerEmail;
    private String freelancerEmail;
    private float bidAmount;
    private int duration;
    private String status;
    private boolean awarded;
}
