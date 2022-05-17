package com.project.travelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum UserRoleEnum {

    CLIENT("CLIENT"),
    EMPLOYEE("EMPLOYEE"),
    ADMIN("ADMIN");

    public String alias;

    @Override
    public String toString() {
        return "UserRoleEnum{" +
                "alias='" + alias + '\'' +
                '}';
    }
}
