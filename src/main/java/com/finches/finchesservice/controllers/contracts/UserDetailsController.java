package com.finches.finchesservice.controllers.contracts;

import com.finches.finchesservice.exceptions.apiexceptions.DuplicateException;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserDetailsController {

    @PostMapping("/user")
    ResponseEntity<Object> save(@RequestBody UserDetailsModel userDetails) throws DuplicateException;
}
