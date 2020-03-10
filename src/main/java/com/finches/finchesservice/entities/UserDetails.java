package com.finches.finchesservice.entities;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("UserDetails")
public class UserDetails {
    @NonNull
    @Id
    private String id;
    @NonNull
    private String userName;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;

    public UserDetails(String userName, String name, String email, String password) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
