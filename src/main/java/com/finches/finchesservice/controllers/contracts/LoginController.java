package com.finches.finchesservice.controllers.contracts;

import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.models.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginController {

    @PostMapping("/login")
    ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) throws InvalidCredentialsException, NoDataFoundException;
}
