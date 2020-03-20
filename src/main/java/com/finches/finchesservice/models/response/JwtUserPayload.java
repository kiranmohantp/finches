package com.finches.finchesservice.models.response;

import java.util.Objects;

public class JwtUserPayload {
    private String encodedId;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncodedId() {
        return encodedId;
    }

    public void setEncodedId(String encodedId) {
        this.encodedId = encodedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JwtUserPayload that = (JwtUserPayload) o;
        return Objects.equals(getEncodedId(), that.getEncodedId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEncodedId());
    }

    @Override
    public String toString() {
        return "UserJwtDetails{" +
                "encodedId='" + encodedId + '\'' +
                ", userName='" + userName + '\'' +
                '}';


    }
}
