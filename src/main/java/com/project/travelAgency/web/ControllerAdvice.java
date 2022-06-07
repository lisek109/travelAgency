package com.project.travelAgency.web;


import com.project.travelAgency.exception.NoIdException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NoIdException.class)
    public String exceptionHandler(NoIdException e) {
        return e.getMessage();
    }
}
