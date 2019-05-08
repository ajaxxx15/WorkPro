package com.stackroute.freelancerprofile.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.*;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Skill {
//    private Map<String, List<Freelancer>> hm=new HashMap<String, List<Freelancer>>();

@Id
private String id;
    private String skill;
    private List<Freelancer> list;
}
