package com.greenhouse.greenhouse.responses;

import com.greenhouse.greenhouse.models.Role;
import com.greenhouse.greenhouse.models.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public class UserResponse {

    private String username;

    private Role role;

    public UserResponse (String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public Role getRole () {
        return role;
    }

    public void setRole (Role role) {
        this.role = role;
    }

}
