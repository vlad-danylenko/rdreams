package com.spring.rdreams.service;

import com.spring.rdreams.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<Long, UserDTO> users = new HashMap<>();

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        users.put(userDTO.getId(), userDTO);
        return userDTO;
    }

    @Override
    public UserDTO getById(Long id) {
        return users.get(id);
    }

    @Override
    public UserDTO getByName(String name) {
        for (UserDTO user : users.values()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDTO getByEmail(String email) {
        for (UserDTO user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        long userIdRequest = userDTO.getId();
        users.replace(userIdRequest, userDTO);
        if (users.get(userIdRequest) == null) {
            return null;
        }
        return userDTO;
    }

    @Override
    public UserDTO deleteUser(Long id) {
        users.remove(id);
        return null;
    }


}
