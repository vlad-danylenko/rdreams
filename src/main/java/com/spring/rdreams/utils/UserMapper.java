package com.spring.rdreams.utils;

import com.spring.rdreams.dto.RoleDTO;
import com.spring.rdreams.dto.UserDTO;
import com.spring.rdreams.entity.Role;
import com.spring.rdreams.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO toDto (User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRoleList(user.getRoleList().stream()
                .map(role -> new RoleDTO(role.getId(), role.getName()))
                .collect(Collectors.toList()));
        return dto;
    }
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        if (userDTO.getRoleList() != null) {
            user.setRoleList(userDTO.getRoleList().stream()
                    .map(roleDTO -> new Role(roleDTO.getId(), roleDTO.getName()))
                    .collect(Collectors.toList()));
        }
        return user;
    }
}
