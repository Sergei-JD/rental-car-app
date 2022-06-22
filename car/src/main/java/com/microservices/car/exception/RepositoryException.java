package com.microservices.car.exception;

public class RepositoryException extends RuntimeException {

    public RepositoryException(String message) {
        super(message);
    }
}
