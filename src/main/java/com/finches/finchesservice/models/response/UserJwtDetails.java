package com.finches.finchesservice.models.response;

public class UserJwtDetails {
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
    public String toString() {
        return "UserJwtDetails{" +
                "encodedId='" + encodedId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
