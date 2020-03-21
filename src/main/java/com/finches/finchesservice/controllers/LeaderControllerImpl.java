package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.LeaderController;
import com.finches.finchesservice.models.entitymodels.LeaderModel;
import com.finches.finchesservice.services.contracts.business.LeaderService;
import com.finches.finchesservice.utils.ResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leader")
public class LeaderControllerImpl implements LeaderController {
    @Autowired
    private LeaderService leaderService;

    @Override
    public ResponseEntity<LeaderModel> save(LeaderModel model) {
        return ResponseUtility.saveResponse(leaderService.save(model));
    }

    @Override
    public ResponseEntity<LeaderModel> update(LeaderModel model) {
        return ResponseUtility.updateResponse(leaderService.update(model));
    }

    @Override
    public ResponseEntity<LeaderModel> getAll() {
        return ResponseUtility.getResponse(leaderService.getAll());
    }

    @Override
    public ResponseEntity<LeaderModel> getById(String id) {
        return ResponseUtility.getResponse(leaderService.getById(id));
    }

    @Override
    public ResponseEntity<String> delete(String id) {
        return ResponseUtility.deleteResponse(leaderService.delete(id));
    }
}
