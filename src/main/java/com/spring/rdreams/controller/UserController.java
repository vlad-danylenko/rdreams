package com.spring.rdreams.controller;

import com.spring.rdreams.dto.UserDTO;
import com.spring.rdreams.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add new user
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/requestBody")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    // update user
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    // delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

    // get user by id
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/parameter/userid/{userId}")
    public ResponseEntity<UserDTO> getUserId(@PathVariable("userId") Long userID) {
        return ResponseEntity.ok(userService.getById(userID));
    }

    // get user by name
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/parameter/username/{name}")
    public ResponseEntity<UserDTO> getUserName(@PathVariable("name") String name) {
        return ResponseEntity.ok(userService.getByName(name));
    }

    // get user by email
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/parameter/email/{email}")
    public ResponseEntity<UserDTO> getUserEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }
}
