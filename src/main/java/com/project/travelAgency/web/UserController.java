package com.project.travelAgency.web;

import com.project.travelAgency.entities.User;
import com.project.travelAgency.entities.UserDTO;
import com.project.travelAgency.entities.UserMapper;
import com.project.travelAgency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
//@Secured("ROLE_USER")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    //@PreAuthorize("authentication.principal.id==#id")
    public ResponseEntity<UserDTO> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(userMapper.toDTO(userService.findById(id)));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup( @RequestBody User user) {
        return ResponseEntity.ok(userMapper.toDTO(userService.save(user)));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("authentication.principal.id==#id")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}