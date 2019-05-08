package com.stackroute.ProjectDetails.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="ProjectsOfProjectOwner")
public class ProjectsOfProjectOwner {

    @Id
    @NotNull(message = "Project Owner Email id can't be null")
    private String projectOwnerEmailId;
    private String projectOwnerName;
    private List<ProjectDetails> projectDetailsList=new ArrayList<>();
}
