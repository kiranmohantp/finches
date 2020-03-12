package com.finches.finchesservice.controllers;

import com.finches.finchesservice.models.request.LoginRequest;
import com.finches.finchesservice.models.response.UserJwtDetails;
import com.finches.finchesservice.services.UserDetailsService;
import com.finches.finchesservice.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    public static final String LOGIN_URL = "/login";

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(LOGIN_URL)
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        UserJwtDetails userDetails = userDetailsService.getUserDataForAuthenticationByUserName(loginRequest.getUserName());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jwtHelper.generateToken(userDetails));
    }
    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SecurityContextHolder.getContext().getAuthentication().toString());
    }
}
