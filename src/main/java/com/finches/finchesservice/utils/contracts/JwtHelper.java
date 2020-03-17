package com.finches.finchesservice.utils.contracts;

import com.finches.finchesservice.models.response.UserJwtDetails;

public interface JwtHelper {
    String generateToken(UserJwtDetails userDetails);

    Boolean validateToken(String token, UserJwtDetails userJwtDetails);

    String getEncodedId(String token);
}
