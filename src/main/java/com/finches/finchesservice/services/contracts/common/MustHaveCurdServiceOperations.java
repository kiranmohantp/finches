package com.finches.finchesservice.services.contracts.common;

import java.util.List;

public interface MustHaveCurdServiceOperations<T> {
    T save(T model);

    T update(T model);

    List<T> getAll();

    T getById(String id);

    String delete(String id);
}
