package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.MenuItem;
import com.cvent.capstone.repositories.MenuItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class MenuItemControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Test
    void shouldReturnMenuItemById() {
        // Given
        // Assuming that the MenuItemRepository has a method to find menu items by ID
        // and that there is a menu item with ID 1 in the database.
        long testMenuItemId = 1;

        // When
        ResponseEntity<MenuItem> response = restTemplate.getForEntity("/api/menu_items/" + testMenuItemId, MenuItem.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(testMenuItemId);
    }

    @Test
    void shouldReturn404WhenMenuItemNotFound() {
        // Given
        long nonExistentMenuItemId = 9999; // Assuming this ID does not exist in the database

        // When
        ResponseEntity<MenuItem> response = restTemplate.getForEntity("/api/menu_items/" + nonExistentMenuItemId, MenuItem.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
