package com.stackroute.ProjectDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;
@Document(collection = "skillSet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skills {

    @Id
    @NotNull(message = "Skill Name can't be null")
    private  String skillName;
    private List<ProjectDetails> projectDetailsList;

}
