package com.project.travelAgency.web;

import com.project.travelAgency.entities.User;
import com.project.travelAgency.entities.UserDTO;
import com.project.travelAgency.entities.UserMapper;
import com.project.travelAgency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable final String id) {
        return ResponseEntity.ok(userMapper.toDTO(userService.findById(id)));
    }

    @GetMapping
    public List<User> findALl() {
        return userService.findAll();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
