package com.cvent.capstone.repositories;

import com.cvent.capstone.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findAll();

    MenuItem save(MenuItem menuItem);

    Optional<MenuItem> findById(Long id);

    void delete(MenuItem menuItem);
}
