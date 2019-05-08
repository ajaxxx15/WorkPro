package com.stackroute.RecommendationService.repository;

import com.stackroute.RecommendationService.domain.ProjectsNeo4j;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsNeo4jRecommendationRepository extends Neo4jRepository<ProjectsNeo4j,String> {
    @Query("MATCH (p:Projects),(s:Field) where s.name=({skillName}) match(s)<-[:RequiresSkill]-(p) RETURN p LIMIT 10")
    public List<ProjectsNeo4j> findBySkills(String skillName);

    @Query("CREATE (p:Projects{ProjectId:({ProjectId}),projectOwnerEmailId:({projectOwnerEmailId}),projectDescription:({projectDescription}),projectName:({projectName})})")
    public List<ProjectsNeo4j> saveByProjectId(String ProjectId,String projectOwnerEmailId,String projectDescription,String projectName);

    @Query("MATCH (p:Projects) where p.ProjectId=({ProjectId})\n" +
            "match (s:Field) where s.name=({skillName}) \n" +
            "create (p)-[:RequiresSkill]->(s)")
    public List<ProjectsNeo4j> saveBySkill(String ProjectId,String skillName);
}
