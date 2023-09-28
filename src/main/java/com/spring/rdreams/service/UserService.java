package com.spring.rdreams.service;

import com.spring.rdreams.dto.UserDTO;
import org.apache.catalina.User;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    UserDTO getById(Long id);
    UserDTO getByName(String name);
    UserDTO getByEmail(String email);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO deleteUser(Long id);


}
