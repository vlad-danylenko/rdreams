package com.spring.rdreams.unit;

import com.spring.rdreams.dto.RoleDTO;
import com.spring.rdreams.dto.UserDTO;
import com.spring.rdreams.entity.Role;
import com.spring.rdreams.entity.User;
import com.spring.rdreams.utils.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest {

    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        userMapper = new UserMapper();
    }

    @Test
    public void testToDTO() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setName("Test User");

        Role role = new Role();
        role.setId(1L);
        role.setName("admin");

        user.setRoleList(List.of(role));


        UserDTO dto = userMapper.toDto(user);


        assertEquals(1L, dto.getId());
        assertEquals("test@example.com", dto.getEmail());
        assertEquals("Test User", dto.getName());
        assertNotNull(dto.getRoleList());
        assertEquals(1L, dto.getRoleList().get(0).getId());
        assertEquals("admin", dto.getRoleList().get(0).getName());
    }

    @Test
    public void testToEntity() {

        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setEmail("test@example.com");
        dto.setName("Test User");

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        roleDTO.setName("admin");

        dto.setRoleList(List.of(roleDTO));

        User user = userMapper.toEntity(dto);

        assertEquals(1L, user.getId());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("Test User", user.getName());

        assertNotNull(user.getRoleList());
        assertEquals(1, user.getRoleList().size());

        Role role1 = user.getRoleList().get(0);
        assertEquals(1L, role1.getId());
        assertEquals("admin", role1.getName());
    }
}
