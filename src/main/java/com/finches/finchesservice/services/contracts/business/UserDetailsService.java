package com.finches.finchesservice.services.contracts.business;

import com.finches.finchesservice.exceptions.apiexceptions.DuplicateException;
import com.finches.finchesservice.exceptions.apiexceptions.InvalidCredentialsException;
import com.finches.finchesservice.exceptions.apiexceptions.NoDataFoundException;
import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import com.finches.finchesservice.models.request.LoginRequest;
import com.finches.finchesservice.models.response.JwtUserPayload;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface UserDetailsService {
    JwtUserPayload getUserDataForAuthenticationByUserName(LoginRequest loginRequest) throws NoDataFoundException, InvalidCredentialsException;

    JwtUserPayload getUserDataForAuthenticationByEncodedId(String encodedId) throws NoDataFoundException;

    UserDetailsModel validateAndSave(@Valid UserDetailsModel userDetails) throws DuplicateException;
}
