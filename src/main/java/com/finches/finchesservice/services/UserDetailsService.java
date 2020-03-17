package com.finches.finchesservice.services;

import com.finches.finchesservice.constents.CommonMessages;
import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.mappers.entity_to_response.UserDetailsToUserJwtDetailsMapper;
import com.finches.finchesservice.models.response.UserJwtDetails;
import com.finches.finchesservice.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private UserDetailsToUserJwtDetailsMapper userDetailsToUserJwtDetailsMapper;

    public UserJwtDetails getUserDataForAuthenticationByUserName(String userName) {
        UserDetails userDetails = userDetailsRepository.getByUserName(userName);
        if (userDetails == null) {
            throw new InvalidCredentialsException(CommonMessages.NO_USER_FOUND);
        }
        return userDetailsToUserJwtDetailsMapper.mapFromAToB(userDetails);
    }
    public UserJwtDetails getUserDataForAuthenticationByEncodedId(String encodedId) {
        UserDetails userDetails = userDetailsRepository.getById(encodedId);
        if (userDetails == null) {
            throw new NoDataFoundException(CommonMessages.NO_DATA_FOUND);
        }
        return userDetailsToUserJwtDetailsMapper.mapFromAToB(userDetails);
    }

}
