package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.MenuItem;
import com.cvent.capstone.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
