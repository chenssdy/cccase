package com.cccase.casebackend.util.exception;


public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
