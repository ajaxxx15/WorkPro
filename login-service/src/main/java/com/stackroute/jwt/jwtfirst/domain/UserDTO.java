package com.stackroute.jwt.jwtfirst.domain;

import com.stackroute.jwt.jwtfirst.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private User user;
    private String token;

}
