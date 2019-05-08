package com.stackroute.RecommendationService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectKafka {
    private String projectOwnerEmailId;
    private String projectName;
    private String projectDescription;
    private String projectId;
    private String skillsSetList;
}


