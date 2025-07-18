package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.Order;
import com.cvent.capstone.repositories.OrderRepository;
import org.junit.jupiter.api.DisplayName;
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

public class OrderControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void returnsOrderById(){
        int testOrderNum = 1001;
        // Given
        // Assume that Order 1001 already exists

        // When
        ResponseEntity<Order> response = restTemplate.getForEntity("/api/orders/" + testOrderNum, Order.class);

        // Then
         assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
         assertThat(response.getBody().getId()).isEqualTo(testOrderNum);
    }

}
