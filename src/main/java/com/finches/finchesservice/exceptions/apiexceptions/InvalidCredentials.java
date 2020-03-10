package com.finches.finchesservice.exceptions.apiexceptions;

import com.finches.finchesservice.entities.UserDetails;

public class InvalidCredentials extends RuntimeException {
    private static String message = "INVALID CREDENTIALS FOR - ";

    public InvalidCredentials(UserDetails userDetails) {
        super(message + userDetails.getUserName());
    }
}
