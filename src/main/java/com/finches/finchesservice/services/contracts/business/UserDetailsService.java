package com.finches.finchesservice.services.contracts.business;

import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import com.finches.finchesservice.models.request.LoginRequest;
import com.finches.finchesservice.models.response.UserJwtDetails;

public interface UserDetailsService {
    UserJwtDetails getUserDataForAuthenticationByUserName(LoginRequest loginRequest) throws NoDataFoundException, InvalidCredentialsException;

    UserJwtDetails getUserDataForAuthenticationByEncodedId(String encodedId) throws NoDataFoundException;

    UserDetailsModel save(UserDetailsModel userDetails);
}
