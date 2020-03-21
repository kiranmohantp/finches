package com.finches.finchesservice.models.entitymodels;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDetailsModel extends RepresentationModel<UserDetailsModel> {
    private String id;
    @NotNull(message = "notnull")
    @Size(min = 4, max = 50, message = "minmax.username")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "invalid.username")
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

    @Override
    public String toString() {
        return "UserDetailsModel{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
