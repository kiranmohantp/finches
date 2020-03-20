package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.LoginController;
import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.models.request.LoginRequest;
import com.finches.finchesservice.models.response.JwtUserPayload;
import com.finches.finchesservice.services.contracts.business.UserDetailsService;
import com.finches.finchesservice.utils.contracts.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControllerImpl implements LoginController {

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public ResponseEntity<String> loginUser(LoginRequest loginRequest) throws InvalidCredentialsException, NoDataFoundException {
        JwtUserPayload userDetails = userDetailsService.getUserDataForAuthenticationByUserName(loginRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jwtHelper.generateToken(userDetails));
    }

}
