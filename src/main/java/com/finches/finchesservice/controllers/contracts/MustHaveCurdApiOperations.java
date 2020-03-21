package com.finches.finchesservice.controllers.contracts;

import com.finches.finchesservice.models.entitymodels.FinchesModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MustHaveCurdApiOperations<T> {
    @PostMapping
    ResponseEntity<T> save(@RequestBody T model);

    @PutMapping
    ResponseEntity<T> update(@RequestBody T model);

    @GetMapping
    ResponseEntity<T> getAll();

    @GetMapping("/{id}")
    ResponseEntity<T> getById(@PathVariable("id") String id);

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable("id") String id);
}
