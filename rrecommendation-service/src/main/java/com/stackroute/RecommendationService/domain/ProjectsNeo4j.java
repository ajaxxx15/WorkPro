package com.stackroute.RecommendationService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.stereotype.Component;

import java.util.List;
@NodeEntity(label = "Projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@QueryResult
public class ProjectsNeo4j {
    @Id
    private String ProjectId;
    private String projectName;
    private String projectOwnerEmailId;
    private String projectDescription;
    @Relationship(type = "RequiresSkill",direction = Relationship.OUTGOING)
    List<Skill> skills;
}
