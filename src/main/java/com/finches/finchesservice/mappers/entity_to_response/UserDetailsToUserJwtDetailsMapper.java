package com.finches.finchesservice.mappers.entity_to_response;

import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.mappers.Mapper;
import com.finches.finchesservice.models.response.UserJwtDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsToUserJwtDetailsMapper implements Mapper<UserDetails, UserJwtDetails> {

    @Override
    public UserJwtDetails mapFromAToB(UserDetails object1) {
        UserJwtDetails userJwtDetails = new UserJwtDetails();
        userJwtDetails.setEncodedId(object1.getId());
        userJwtDetails.setUserName(object1.getUserName());
        return userJwtDetails;
    }

    @Override
    public UserDetails mapFromBToA(UserJwtDetails object1) {
        throw new RuntimeException("Not implemented");
    }


}
