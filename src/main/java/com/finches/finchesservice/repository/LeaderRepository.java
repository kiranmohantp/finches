package com.finches.finchesservice.repository;

import com.finches.finchesservice.entities.Leader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeaderRepository extends MongoRepository<Leader, String> {
}
