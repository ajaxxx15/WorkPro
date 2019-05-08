package com.stackroute.ProjectDetails.exceptions;

public class ProjectAlreadyExistsException extends Exception {
    private String message;

    public ProjectAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public ProjectAlreadyExistsException() {
    }
}
