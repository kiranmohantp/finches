package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.LeaderController;
import com.finches.finchesservice.models.entitymodels.LeaderModel;
import com.finches.finchesservice.services.contracts.business.LeaderService;
import com.finches.finchesservice.services.contracts.common.MustHaveCurdServiceOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leader")
public class LeaderControllerImpl extends MustHaveApiAbstract<LeaderModel> implements LeaderController {
    @Autowired
    private LeaderService leaderService;

    @Override
    public MustHaveCurdServiceOperations getService() {
        return leaderService;
    }
}
