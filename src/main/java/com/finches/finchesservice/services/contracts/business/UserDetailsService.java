package com.finches.finchesservice.services.contracts.business;

import com.finches.finchesservice.models.entitymodels.UserDetailsModel;
import com.finches.finchesservice.models.request.LoginRequest;
import com.finches.finchesservice.models.response.JwtUserPayload;
import com.finches.finchesservice.services.contracts.common.MustHaveCurdServiceOperations;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserDetailsService extends MustHaveCurdServiceOperations<UserDetailsModel> {
    JwtUserPayload getUserDataForAuthenticationByUserName(LoginRequest loginRequest);

    JwtUserPayload getUserDataForAuthenticationByEncodedId(String encodedId);
}
