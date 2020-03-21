package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.UserDetailsController;
import com.finches.finchesservice.exceptions.apiexceptions.DuplicateException;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import com.finches.finchesservice.services.contracts.business.UserDetailsService;
import com.finches.finchesservice.utils.ResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserDetailsControllerImpl implements UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public ResponseEntity<UserDetailsModel> save(UserDetailsModel model) {
        return ResponseUtility.saveResponse(userDetailsService.save(model));
    }

    @Override
    public ResponseEntity<UserDetailsModel> update(UserDetailsModel model) {
        return null;
    }

    @Override
    public ResponseEntity<UserDetailsModel> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<UserDetailsModel> getById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(String id) {
        return null;
    }

}
