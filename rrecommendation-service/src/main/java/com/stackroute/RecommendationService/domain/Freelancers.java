package com.stackroute.RecommendationService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity(label = "Freelancers")
@Builder
@Component
@QueryResult
public class Freelancers {
//    @Id
//    private String EmailId;
//
//    @Relationship(type = "hasSkill",direction = Relationship.OUTGOING)
//    List<Skill> skills;

    private String id;
    private String freelancerName;
    @Id
    private String freelancerEmail;
    private String freelancerAddress;
    private int yearsOfExpertise;
    @Relationship(type = "hasSkill",direction = Relationship.OUTGOING)
    private ArrayList<String> skills;
}
