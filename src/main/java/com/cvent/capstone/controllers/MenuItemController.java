package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.MenuItem;
import com.cvent.capstone.services.MenuItemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu_items")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping
    public List<MenuItem> getMenuItems() {
        return menuItemService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a menu item by ID")
    public MenuItem getMenuItemById(@PathVariable Long id) {
        return menuItemService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new menu item")
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.save(menuItem);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing menu item")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem updatedItem) {
        MenuItem result = menuItemService.updateMenuItem(id, updatedItem);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a menu item by ID")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        MenuItem existingItem = menuItemService.findById(id);
        menuItemService.delete(existingItem);
        return ResponseEntity.noContent().build();
    }
}
