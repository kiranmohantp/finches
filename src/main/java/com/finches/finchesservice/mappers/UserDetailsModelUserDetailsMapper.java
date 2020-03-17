package com.finches.finchesservice.mappers;

import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.mappers.contracts.Mapper;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userDetailsModelToUserDetailsMapper")
public class UserDetailsModelUserDetailsMapper implements Mapper<UserDetailsModel, UserDetails> {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails mapFromAToB(UserDetailsModel userDetailsModel) {
        return new UserDetails(userDetailsModel.getId(),
                userDetailsModel.getUserName(),
                userDetailsModel.getName(),
                userDetailsModel.getEmail(),
                passwordEncoder.encode(userDetailsModel.getPassword()));
    }

    @Override
    public UserDetailsModel mapFromBToA(UserDetails userDetails) {
        return new UserDetailsModel(userDetails.getId(),
                userDetails.getUserName(),
                userDetails.getName(),
                userDetails.getEmail(),
                null);
    }
}
