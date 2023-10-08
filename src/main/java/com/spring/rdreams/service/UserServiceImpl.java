package com.spring.rdreams.service;

import com.spring.rdreams.dto.UserDTO;
import com.spring.rdreams.entity.User;
import com.spring.rdreams.repository.UserJPARepository;
import com.spring.rdreams.utils.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserJPARepository userJPARepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserJPARepository userJPARepository, UserMapper userMapper) {
        this.userJPARepository = userJPARepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        if (!userJPARepository.existsById(user.getId())) {
            user = userJPARepository.save(user);
            return userMapper.toDto(user);
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UserDTO> findById(Long id) {
        return userJPARepository.findById(id).map(userMapper::toDto);
    }


    @Override
    public Optional<UserDTO> getByName(String name) {
        List<User> users = userJPARepository.findByName(name);
        if (!users.isEmpty()) {
            return Optional.of(userMapper.toDto(users.get(0)));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> getByEmail(String email) {
        return userJPARepository.findByEmail(email).map(userMapper::toDto);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (userJPARepository.existsById(id)) {
            User user = userMapper.toEntity(userDTO);
            user.setId(id);
            user = userJPARepository.save(user);
            return userMapper.toDto(user);
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUser(Long id) {
        userJPARepository.deleteById(id);
    }

}
