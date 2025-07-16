package com.cvent.capstone.repositories;

import com.cvent.capstone.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findAll();
//    TODO: add all the methods for menuItems
}
