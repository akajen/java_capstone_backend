package com.cvent.capstone.repositories;

import com.cvent.capstone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User save(User user);

    Optional<User> findById(Long id);

    void delete(User user);
}
