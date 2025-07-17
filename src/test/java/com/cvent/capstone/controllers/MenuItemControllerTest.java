package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.MenuItem;
import com.cvent.capstone.repositories.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MenuItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MenuItemRepository menuItemRepository;

    // TODO: Come back and modify this after finishing save all method
    @BeforeEach
    public void setup() {
        // Clear DB and add test data
        menuItemRepository.deleteAll();

        MenuItem item1 = new MenuItem((long) 1, "Burger", "Juicy beef burger with cheese", "dinner", (double) 5.99, "/images/burger.jpg", true);
        MenuItem item2 = new MenuItem((long) 2, "Fries", "Crispy goldern fries", "side", (double) 2.99, "/images/fries.jpg", true);
        menuItemRepository.saveAll(List.of(item1, item2));
    }

    @Test
    public void testGetMenuItemsReturnsAll() throws Exception {
        mockMvc.perform(get("/api/menu_items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Burger"))
                .andExpect(jsonPath("$[1].name").value("Fries"));
    }
}