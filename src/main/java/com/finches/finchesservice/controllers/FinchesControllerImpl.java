package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.FinchesController;
import com.finches.finchesservice.models.entitymodels.FinchesModel;
import com.finches.finchesservice.services.contracts.business.FinchesService;
import com.finches.finchesservice.services.contracts.common.MustHaveCurdServiceOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finches")
public class FinchesControllerImpl extends MustHaveApiAbstract<FinchesModel> implements FinchesController {
    @Autowired
    private FinchesService finchesService;

    @Override
    public MustHaveCurdServiceOperations getService() {
        return finchesService;
    }

}
