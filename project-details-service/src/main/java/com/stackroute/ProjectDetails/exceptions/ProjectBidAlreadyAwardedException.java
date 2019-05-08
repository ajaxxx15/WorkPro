package com.stackroute.ProjectDetails.exceptions;

public class ProjectBidAlreadyAwardedException extends Exception {
    private String message;

    public ProjectBidAlreadyAwardedException(String message) {
        super(message);
        this.message = message;
    }

    public ProjectBidAlreadyAwardedException() {
    }
}
