package com.cvent.capstone.services;

import com.cvent.capstone.entities.MenuItem;
import com.cvent.capstone.repositories.MenuItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepo menuItemRepo;

    public List<MenuItem> findAll() {
        return menuItemRepo.findAll();
    }
}
