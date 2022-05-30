package com.project.travelAgency.web;

import com.project.travelAgency.entities.User;
import com.project.travelAgency.entities.UserDTO;
import com.project.travelAgency.entities.UserMapper;
import com.project.travelAgency.entities.UserRole;
import com.project.travelAgency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Secured("ROLE_ADMIN")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/admin")
public class UserAdminController {

    private final UserService userService;
   // private static final List<UserRole> ADMIN = List.of(new UserRole(2L, "ADMIN"));
    private static final UserRole ADMIN = new UserRole(2L, "ADMIN");
    private final UserMapper userMapper;


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(userMapper.toDTO(userService.findById(id)));
    }

    @GetMapping
    public List<UserDTO> findALl() {
        return userService.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PatchMapping("/signup/{id}")
    public ResponseEntity<String> giveAdminRole( @PathVariable("id") Long id) {

      //  userService.findById(id).getUserRoles().clear();
        User user = userService.findById(id);
        user.getUserRoles().add(ADMIN);
        userService.save(user);

        String ok = "Role changed!!";
        return ResponseEntity.ok(ok);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}

