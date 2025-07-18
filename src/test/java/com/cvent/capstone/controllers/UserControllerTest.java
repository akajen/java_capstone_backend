package com.cvent.capstone.controllers;

import com.cvent.capstone.entities.User;
import com.cvent.capstone.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Disabled
    void shouldCreateUser() {
        // Given
        User userRequest = new User(
                (long) 1,
                "Username",
                "Password",
                "Firstname",
                "Lastname",
                "1234567890",
                "email@gmail.com",
                "www.example.com/image.jpg",
                "ABCDE1234F",
                (long)123,
                (long)2025,
                "ROLE_USER");

        // When
        ResponseEntity<User> response = restTemplate.postForEntity(
                "/api/users",
                userRequest,
                User.class
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody().getUsername()).isEqualTo("Username");
        assertThat(userRepository.count()).isEqualTo(1);
    }

    @Test
    void shouldReturnUserById() {
        // Given
        User newUser = User.builder()
                .username("testUsername")
                .password("testPassword")
                .firstName("Firstname")
                .lastName("Lastname")
                .phone("1234567890")
                .email("email@gmail.com")
                .imageUrl("www.example.com/image.jpg")
                .pan("ABCDE1234F")
                .expiryMonth((long) 123)
                .expiryYear((long) 2025)
                .roles("ROLE_USER").build();

        User savedUser = userRepository.save(newUser);

        // When
        ResponseEntity<User> response = restTemplate.getForEntity(
                "/api/users/" + savedUser.getId(),
                User.class
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getUsername()).isEqualTo("testUsername");
    }
}

