package com.cvent.capstone.services;

import com.cvent.capstone.entities.MenuItem;
import com.cvent.capstone.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    public MenuItem save(MenuItem menuItem) {
        if(menuItem.getAvailable() == null) {
            menuItem.setAvailable(true);
        }
        return menuItemRepository.save(menuItem);
    }

    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "MenuItem not found"));
    }

    public MenuItem updateMenuItem(Long id, MenuItem updatedItem){
        MenuItem existingItem = this.findById(id);

        existingItem.setName(updatedItem.getName());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setCategory(updatedItem.getCategory());

        return menuItemRepository.save(existingItem);
    }

    public void delete(MenuItem menuItem) {
        menuItemRepository.delete(menuItem);
    }
}
