package com.cvent.capstone.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ORDER_ITEMS")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name="ORDERID")
    private Long orderId;

    @Column(nullable = false, name="ITEMID")
    private Long itemId;

    @Column(nullable = false, name="PRICE")
    private Double price;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name = "NOTES")
    private String notes;
}
