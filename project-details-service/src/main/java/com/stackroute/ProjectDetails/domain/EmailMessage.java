package com.stackroute.ProjectDetails.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmailMessage {
    private String to;
    private String subject;
    private  String body;
}
