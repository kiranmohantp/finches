package com.finches.finchesservice.controllers;

import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    private static final String CREATE_USER = "";


    @PostMapping(CREATE_USER)
    public ResponseEntity<Object> createUser(){
        UserDetails userDetails = new UserDetails("kiran","kiramohan","email","test");
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsRepository.save(userDetails));
    }
}
