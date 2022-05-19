package com.project.travelAgency.web;

import com.project.travelAgency.entities.User;
import com.project.travelAgency.entities.UserRole;
import com.project.travelAgency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/admin")
public class UserAdminController {

    private final UserService userService;
    private static final List<UserRole> ADMIN = List.of(new UserRole(2L, "ADMIN"));


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<User> findALl() {
        return userService.findAll();
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/signup/{id}")
    public ResponseEntity<String> giveAdminRole(@RequestBody User user, @PathVariable("id") Long id) {

        userService.findById(id).getUserRoles().clear();
        userService.findById(id).setUserRoles(ADMIN);
        String ok = "Role changed!!";
        return ResponseEntity.ok(ok);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}

