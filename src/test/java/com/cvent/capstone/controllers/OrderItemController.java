package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.OrderItems;
import com.cvent.capstone.repositories.OrderItemsRepository;
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
public class OrderItemController {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Test
    void shouldReturnOrderItemById(){
        // Given
        // Assuming that the OrderItemsRepository has a method to find order items by order ID
        // and that there is an order with ID 1 in the database.
        long testOrderItemId = 1;
        // When
        ResponseEntity<OrderItems> response = restTemplate.getForEntity("/api/items/" + testOrderItemId, OrderItems.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(testOrderItemId);
    }
}
