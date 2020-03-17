package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.UserDetailsController;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import com.finches.finchesservice.services.business.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsControllerImpl implements UserDetailsController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public ResponseEntity<Object> createUser(UserDetailsModel userDetails) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsService.save(userDetails));
    }
}
