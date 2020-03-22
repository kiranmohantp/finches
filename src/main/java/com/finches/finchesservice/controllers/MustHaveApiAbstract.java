package com.finches.finchesservice.controllers;

import com.finches.finchesservice.controllers.contracts.MustHaveCurdApiOperations;
import com.finches.finchesservice.services.contracts.common.MustHaveCurdServiceOperations;
import com.finches.finchesservice.utils.ResponseUtility;
import org.springframework.http.ResponseEntity;

public abstract class MustHaveApiAbstract<T> implements MustHaveCurdApiOperations<T> {
    public abstract MustHaveCurdServiceOperations getService();

    @Override
    public ResponseEntity<T> save(T model) {
        return ResponseUtility.saveResponse(getService().save(model));
    }

    @Override
    public ResponseEntity<T> update(T model) {
        return ResponseUtility.updateResponse(getService().update(model));
    }

    @Override
    public ResponseEntity<T> getAll() {
        return ResponseUtility.getResponse(getService().getAll());
    }

    @Override
    public ResponseEntity<T> getById(String id) {
        return ResponseUtility.getResponse(getService().getById(id));
    }

    @Override
    public ResponseEntity<String> delete(String id) {
        return ResponseUtility.deleteResponse(getService().delete(id));
    }
}
