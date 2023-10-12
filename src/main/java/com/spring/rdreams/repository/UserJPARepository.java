package com.spring.rdreams.repository;

import com.spring.rdreams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserJPARepository extends JpaRepository<User,Long> {

    List<User> findByName(String name);
    Optional<User> findByEmail(String email);

    void deleteById(Long id);
}
