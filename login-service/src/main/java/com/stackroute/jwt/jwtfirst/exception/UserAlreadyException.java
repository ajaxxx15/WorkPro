package com.stackroute.jwt.jwtfirst.exception;

public class UserAlreadyException extends Exception{


    private String message;

    public UserAlreadyException(){}

    public UserAlreadyException(String message){
        super(message);
        this.message=message;
    }

}