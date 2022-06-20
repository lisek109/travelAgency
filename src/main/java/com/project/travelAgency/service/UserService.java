package com.project.travelAgency.service;

import com.project.travelAgency.entities.User;
import com.project.travelAgency.entities.UserRole;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private static final UserRole USER = new UserRole(1L, "USER");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUserName(username)
                .orElseThrow(() -> new NoIdException("User not found"));
    }

    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.getUserRoles().add(USER);
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
