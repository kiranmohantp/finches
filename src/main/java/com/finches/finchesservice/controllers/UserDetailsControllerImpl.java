package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.UserDetailsController;
import com.finches.finchesservice.exceptions.apiexceptions.DuplicateException;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import com.finches.finchesservice.services.contracts.business.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsControllerImpl implements UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public ResponseEntity<Object> save(UserDetailsModel userDetails) throws DuplicateException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsService.validateAndSave(userDetails));
    }
}
