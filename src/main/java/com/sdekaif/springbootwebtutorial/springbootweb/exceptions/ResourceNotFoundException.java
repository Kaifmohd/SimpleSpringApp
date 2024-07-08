package com.sdekaif.springbootwebtutorial.springbootweb.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
