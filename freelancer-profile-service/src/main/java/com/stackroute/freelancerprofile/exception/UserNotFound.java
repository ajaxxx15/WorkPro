package com.stackroute.freelancerprofile.exception;

public class UserNotFound extends Exception {
    private String message;
    public UserNotFound(){}
    public UserNotFound(String message){
        super(message);
        this.message=message;
    }
}