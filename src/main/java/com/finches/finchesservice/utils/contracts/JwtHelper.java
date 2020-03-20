package com.finches.finchesservice.utils.contracts;

import com.finches.finchesservice.models.response.JwtUserPayload;

public interface JwtHelper {
    String generateToken(JwtUserPayload userDetails);

    Boolean validateToken(String token, JwtUserPayload userJwtDetails);

    String getEncodedId(String token);
}
