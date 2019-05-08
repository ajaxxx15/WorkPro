package com.stackroute.ProjectDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduceProject {
    private String projectOwnerEmailId;
    private String projectName;
    private String projectDescription;
    private String projectId;
    private String skillsSetList;

}

