package com.spring.rdreams.service;

import com.spring.rdreams.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    Optional<UserDTO> findById(Long id);
    Optional<UserDTO> getByName(String name);
    Optional<UserDTO> getByEmail(String email);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);


}
