package com.farzadafi.exception;

public class ServiceUnavailableException extends RuntimeException{

    public ServiceUnavailableException(String message) {
        super(message);
    }
}
