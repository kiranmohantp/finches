package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.UserDetailsController;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import com.finches.finchesservice.services.contracts.business.UserDetailsService;
import com.finches.finchesservice.services.contracts.common.MustHaveCurdServiceOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserDetailsControllerImpl extends MustHaveApiAbstract<UserDetailsModel> implements UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public MustHaveCurdServiceOperations getService() {
        return userDetailsService;
    }
}
