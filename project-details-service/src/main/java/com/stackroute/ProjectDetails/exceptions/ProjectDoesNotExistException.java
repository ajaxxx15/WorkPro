package com.stackroute.ProjectDetails.exceptions;

public class ProjectDoesNotExistException extends Exception {
    private String message;

    public ProjectDoesNotExistException(String message) {
        super(message);
        this.message = message;
    }

    public ProjectDoesNotExistException() {
    }

}
