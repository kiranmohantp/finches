package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.FinchesController;
import com.finches.finchesservice.models.entitymodels.FinchesModel;
import com.finches.finchesservice.services.contracts.business.FinchesService;
import com.finches.finchesservice.utils.ResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finches")
public class FinchesControllerImpl implements FinchesController {
    @Autowired
    private FinchesService finchesService;
    @Override
    public ResponseEntity<FinchesModel> save(FinchesModel model) {
        return ResponseUtility.saveResponse(finchesService.save(model));
    }

    @Override
    public ResponseEntity<FinchesModel> update(FinchesModel model) {
        return ResponseUtility.updateResponse(finchesService.update(model));
    }

    @Override
    public ResponseEntity<FinchesModel> getAll() {
        return ResponseUtility.getResponse(finchesService.getAll());
    }

    @Override
    public ResponseEntity<FinchesModel> getById(String id) {
        return ResponseUtility.getResponse(finchesService.getById(id));

    }

    @Override
    public ResponseEntity<String> delete(String id) {
        return ResponseUtility.deleteResponse(finchesService.delete(id));

    }
}
