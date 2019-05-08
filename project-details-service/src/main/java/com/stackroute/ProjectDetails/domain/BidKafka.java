package com.stackroute.ProjectDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Component
public class BidKafka {

    private String projectId;
    private String projectOwnerEmail;
    private String projectName;
    private String freelancerEmail;
    private float bidAmount;
    private int duration;
    private String status;
    private boolean awarded;

    public boolean isAwarded() {
        return awarded;
    }
}
