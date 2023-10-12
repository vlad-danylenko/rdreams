package com.spring.rdreams.controller;

import com.spring.rdreams.dto.UserDTO;
import com.spring.rdreams.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add new user
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/requestBody")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        UserDTO createdUser = userService.createUser(userDTO);

        if (createdUser != null) {
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User already created");
        }
    }

    // update user
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO){
        UserDTO updatedUser = userService.updateUser(userId, userDTO);

        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with provided ID not found");
        }
    }

    // delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    // get user by id
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/parameter/userid/{userId}")
    public ResponseEntity<Optional<UserDTO>> findUserById(@PathVariable("userId") Long userID) {
        return ResponseEntity.ok(userService.findById(userID));
    }

    // get user by name
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/parameter/username/{name}")
    public ResponseEntity<Optional<UserDTO>> getUserName(@PathVariable("name") String name) {
        return ResponseEntity.ok(userService.getByName(name));
    }

    // get user by email
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/parameter/email/{email}")
    public ResponseEntity<Optional<UserDTO>> getUserEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }
}
