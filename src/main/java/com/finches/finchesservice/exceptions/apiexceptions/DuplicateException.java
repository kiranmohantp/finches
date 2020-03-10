package com.finches.finchesservice.exceptions.apiexceptions;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message) {
        super(message);
    }
}
