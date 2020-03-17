package com.finches.finchesservice.services.contracts.common;

public interface PasswordValidator {
    boolean checkPasswordsAreSame(String plainPassword, String encodedPassword);
}
