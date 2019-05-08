package com.stackroute.freelancerprofile.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder

public class Freelancer {

    private String id;
    private String freelancerName;
    @Id
    private String freelancerEmail;
    private String freelancerAddress;
    private int yearsOfExpertise;
    private ArrayList<String> skills;

}
