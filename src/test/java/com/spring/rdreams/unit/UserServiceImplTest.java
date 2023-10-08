package com.spring.rdreams.unit;

import com.spring.rdreams.dto.RoleDTO;
import com.spring.rdreams.dto.UserDTO;
import com.spring.rdreams.entity.Role;
import com.spring.rdreams.entity.User;
import com.spring.rdreams.repository.UserJPARepository;
import com.spring.rdreams.service.UserServiceImpl;
import com.spring.rdreams.utils.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserJPARepository userJPARepository;
    @Spy
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setName("Vladyslav");

        Role role = new Role();
        role.setId(1L);
        role.setName("admin");
        user.setRoleList(List.of(role));

        when(userJPARepository.save(any())).thenReturn(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setEmail("test@example.com");
        userDTO.setName("Vladyslav");
        userDTO.setRoleList(List.of(new RoleDTO(1L, "admin")));


        UserDTO resultDTO = userService.createUser(userDTO);

        verify(userJPARepository, times(1)).save(any(User.class));
        assertEquals(1L, resultDTO.getId());
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setName("Vladyslav");

        Role role = new Role();
        role.setId(1L);
        role.setName("admin");
        user.setRoleList(List.of(role));

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setEmail("test@example.com");
        userDTO.setName("Vladyslav");
        userDTO.setRoleList(List.of(new RoleDTO(1L, "admin")));

        given(userJPARepository.findById(1L)).willReturn(Optional.of(user));

        Optional<UserDTO> resultDTO = userService.findById(1L);

        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());


    }

}
