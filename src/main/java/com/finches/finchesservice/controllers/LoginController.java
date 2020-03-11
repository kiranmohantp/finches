package com.finches.finchesservice.controllers;

import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.models.request.LoginRequest;
import com.finches.finchesservice.services.UserDetailsService;
import com.finches.finchesservice.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = userDetailsService.getUserDataForAuthenticationByUserName(loginRequest.getUserName());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jwtHelper.generateToken(userDetails));
    }
}
