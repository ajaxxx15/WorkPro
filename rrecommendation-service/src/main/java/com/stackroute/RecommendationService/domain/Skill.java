package com.stackroute.RecommendationService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@NodeEntity(label = "Skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@QueryResult
public class Skill {
    @Id
    private String skillName;


   // private Double yearsOfExperience;
//   @Relationship(type = "hasSkill",direction = Relationship.INCOMING)
//   List<Freelancers> freelancers;
//
//    @Relationship(type = "RequiresSkill",direction = Relationship.INCOMING)
//    List<Projects> projects;
}
