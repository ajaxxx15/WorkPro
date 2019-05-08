package com.stackroute.ProjectDetails.exceptionHandling;

import com.stackroute.ProjectDetails.exceptions.ProjectAlreadyExistsException;
import com.stackroute.ProjectDetails.exceptions.ProjectBidAlreadyAwardedException;
import com.stackroute.ProjectDetails.exceptions.ProjectDoesNotExistException;
import com.stackroute.ProjectDetails.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingClass {
    @ExceptionHandler(value = ProjectAlreadyExistsException.class)
    public ResponseEntity<?> ProjectAlreadyExistsException(ProjectAlreadyExistsException e) {
        return new ResponseEntity<String>("Player already exists " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ProjectBidAlreadyAwardedException.class)
    public ResponseEntity<?> ProjectBidAlreadyAwardedException(ProjectBidAlreadyAwardedException e) {
        return new ResponseEntity<String>("Bid already awarded " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ProjectDoesNotExistException.class)
    public ResponseEntity<?> ProjectDoesNotExistException(ProjectDoesNotExistException e) {
        return new ResponseEntity<String>("Project does not exist " + e.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> ProjectDoesNotExistException(Exception e) {
        return new ResponseEntity<String>("unknown request " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity<?> UnauthorizedException(UnauthorizedException e) {
        return new ResponseEntity<String>("Please login " + e.getMessage(), HttpStatus.CONFLICT);
    }
}

