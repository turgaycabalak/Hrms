package com.hrms.hrmsproject.core.exceptions;

public class IdentityNumberAlreadyInUseException extends RuntimeException{

    public IdentityNumberAlreadyInUseException(String message) {
        super(message);
    }

}
