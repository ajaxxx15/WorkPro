package com.stackroute.jwt.jwtfirst.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private  String email;
    @Column(name = "password")
    private String password;
    @Column(name = "enable")
    private  boolean enable;
    @Column(name = "role")
    private String role;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "date")
    private Date date;

}
