package com.stackroute.freelancerprofile.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
//@Builder
public class EmailMessage {
    private String to;
    private String subject;
    private String body;
}
