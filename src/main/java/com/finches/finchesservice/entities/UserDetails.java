package com.finches.finchesservice.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Document("UserDetails")
public class UserDetails {
    private String id;
    @NotNull(message = "notnull")
    @Size(min = 4, max = 50, message = "minmax.username")
    private String userName;
    @Size(min = 3, max = 50, message = "minmax.name")
    @NotNull(message = "notnull")
    private String name;
    @NotNull(message = "notnull")
    @Email(message = "invalid.email")
    @Size(min = 3, max = 200, message = "minmax.email")
    private String email;
    @Size(min = 8, max = 100, message = "minmax.password")
    @NotNull(message = "notnull")
    private String password;

    public UserDetails(String id) {
        this.id = id;
    }

    public UserDetails(String id, String userName, String name, String email, String password) {
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
        UserDetails that = (UserDetails) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
