package com.cvent.capstone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, name = "FIRST_NAME")
    private String firstName;

    @Column(nullable = false, name = "LAST_NAME")
    private String lastName;

    @Column
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column
    private String pan;

    @Column(name = "EXPIRY_MONTH")
    private Long expiryMonth;

    @Column(name = "EXPIRY_YEAR")
    private Long expiryYear;

    @Column(nullable = false)
    private String roles;

}
