package com.stackroute.RecommendationService.repository;

import com.stackroute.RecommendationService.domain.Projects;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProjectRecommendationsRepository extends Neo4jRepository<Projects,String> {
    @Query("MATCH (p:Projects),(s:Skill) where s.name=({skillName}) match(s)<-[:RequiresSkill]-(p) RETURN p LIMIT 10")
    public List<Projects> findBySkills(String skillName);

    @Query("CREATE (p:Projects{ProjectId:({ProjectId})})")
    public List<Projects> saveByProjectId(String ProjectId);

    @Query("MATCH (p:Projects) where p.ProjectId=({ProjectId})\n" +
            "match (s:Field) where s.name=({skillName}) \n" +
            "create (p)-[:RequiresSkill]->(s)")
    public List<Projects> saveBySkill(String ProjectId,String skillName);
}