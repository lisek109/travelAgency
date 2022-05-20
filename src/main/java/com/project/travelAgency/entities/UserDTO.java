package com.project.travelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String userName;
    private List<UserRole> roles;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public List<UserRole> getRoles() {
        return roles;
    }
}
