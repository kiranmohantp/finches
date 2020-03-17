package com.finches.finchesservice.controllers.contracts;

import com.finches.finchesservice.constents.api.UserEndPoints;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserDetailsController {

    @PostMapping(UserEndPoints.USER_PATH)
    ResponseEntity<Object> createUser(@RequestBody UserDetailsModel userDetails);
}
