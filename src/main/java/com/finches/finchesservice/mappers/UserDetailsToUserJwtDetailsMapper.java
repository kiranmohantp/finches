package com.finches.finchesservice.mappers;

import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.mappers.contracts.Mapper;
import com.finches.finchesservice.models.response.UserJwtDetails;
import org.springframework.stereotype.Component;

@Component("userDetailsToUserJwtDetailsMapper")
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
        return null;
    }


}
