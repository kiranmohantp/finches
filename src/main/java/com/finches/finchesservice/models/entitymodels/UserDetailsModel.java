package com.finches.finchesservice.models.entitymodels;

import java.util.Objects;

public class UserDetailsModel {
    private String id;
    private String userName;
    private String name;
    private String email;
    private String password;

    public UserDetailsModel(String id, String userName, String name, String email, String password) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsModel that = (UserDetailsModel) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
