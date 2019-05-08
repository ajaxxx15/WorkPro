package com.stackroute.freelancerprofile.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsOfProjectOwner {
    private String projectOwnerEmailId;
    private String projectOwnerName;
//    private List<ProjectDetails> projectDetailsList=new ArrayList<>();
}
