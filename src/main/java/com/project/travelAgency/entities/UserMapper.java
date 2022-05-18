package com.project.travelAgency.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public  UserDTO toDTO(User user) {
        Long userId = user.getId();

        List<UserRole> roles = user
                .getUserRoles();

        return new UserDTO(userId, roles);
    }
}
