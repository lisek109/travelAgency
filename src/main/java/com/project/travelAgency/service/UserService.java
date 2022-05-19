package com.project.travelAgency.service;

import com.project.travelAgency.entities.User;
import com.project.travelAgency.entities.UserRole;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    //private static final List<UserRole> USER= List.of(new UserRole(1L, "USER"));


    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
       // user.setUserRoles(USER);
        return userRepo.save(user);
    }

    public User findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new NoIdException("User with given id not found"));
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public boolean deleteById(Long id) {
        userRepo.deleteById(id);
        return true;
    }

}
