package com.finches.finchesservice.repository;

import com.finches.finchesservice.entities.Finches;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FinchesRepository extends MongoRepository<Finches, String> {
}
