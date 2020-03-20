package com.finches.finchesservice.mappers;

import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.mappers.contracts.Mapper;
import com.finches.finchesservice.models.response.JwtUserPayload;
import org.springframework.stereotype.Component;

@Component("userDetailsToUserJwtDetailsMapper")
public class UserDetailsToUserJwtDetailsMapper implements Mapper<UserDetails, JwtUserPayload> {

    @Override
    public JwtUserPayload mapFromAToB(UserDetails object1) {
        JwtUserPayload userJwtDetails = new JwtUserPayload();
        userJwtDetails.setEncodedId(object1.getId());
        userJwtDetails.setUserName(object1.getUserName());
        return userJwtDetails;
    }

    @Override
    public UserDetails mapFromBToA(JwtUserPayload object1) {
        return null;
    }


}
