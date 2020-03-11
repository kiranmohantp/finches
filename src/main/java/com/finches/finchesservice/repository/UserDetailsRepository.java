package com.finches.finchesservice.repository;

import com.finches.finchesservice.entities.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {
    UserDetails getByUserName(String userName);
}
