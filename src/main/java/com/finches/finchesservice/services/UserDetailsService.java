package com.finches.finchesservice.services;

import com.finches.finchesservice.constents.CommonMessages;
import com.finches.finchesservice.entities.UserDetails;
import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails getUserDataForAuthenticationByUserName(String userName) throws InvalidCredentialsException {
        UserDetails userDetails = userDetailsRepository.getByUserName(userName);
        if (userDetails == null) {
            throw new InvalidCredentialsException(CommonMessages.NO_USER_FOUND);
        }
        return userDetails;
    }
}
